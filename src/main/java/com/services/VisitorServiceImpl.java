package com.services;

import com.daos.VisitorDao;
import com.models.Visitor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {

    private final VisitorDao visitorDao;

    public VisitorServiceImpl(VisitorDao visitorDao) {
        this.visitorDao = visitorDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Visitor> getAll() {
        return visitorDao.getAll();
    }

    @Override
    public void save(Visitor visitor) {
        visitorDao.save(visitor);
    }

    @Override
    public Visitor get(int id) {
        return visitorDao.get(id);
    }

    @Override
    public void update(Visitor visitor) {
        visitorDao.update(visitor);
    }

    @Override
    public void delete(int id) {
        visitorDao.delete(id);
    }

}
