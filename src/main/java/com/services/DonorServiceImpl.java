package com.services;

import com.daos.DonorDao;
import com.models.Donor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {

    private final DonorDao donorDao;

    public DonorServiceImpl(DonorDao donorDao) {
        this.donorDao = donorDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Donor> getAll() {
        return donorDao.getAll();
    }

    @Override
    public List<Donor> getAllByBlood(String bloodType) {
        return donorDao.getAllByBlood(bloodType);
    }

    @Override
    public void save(Donor donor) {
        donorDao.save(donor);
    }

    @Override
    public Donor get(int id) {
        return donorDao.get(id);
    }

    @Override
    public void update(Donor donor) {
        donorDao.update(donor);
    }

    @Override
    public void delete(int id) {
        donorDao.delete(id);
    }

}
