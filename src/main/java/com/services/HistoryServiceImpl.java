package com.services;

import com.daos.HistoryDao;
import com.models.History;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

    private final HistoryDao historyDao;

    public HistoryServiceImpl(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<History> getVisitorHistory(int userid) {
        return historyDao.getVisitorHistory(userid);
    }

    @Override
    public List<History> getDonorHistory(int userid){return historyDao.getDonorHistory(userid);}

    @Override
    public void save(History history) {
        historyDao.save(history);
    }

    @Override
    public History get(int id) {
        return historyDao.get(id);
    }

    @Override
    public void update(History history) {
        historyDao.update(history);
    }

    @Override
    public void delete(int id) {
        historyDao.delete(id);
    }

}
