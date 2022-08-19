package com.services;

import com.daos.DonationDao;
import com.models.Donation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonationServiceImpl implements DonationService {

    private final DonationDao donationDao;

    public DonationServiceImpl(DonationDao donationDao) {
        this.donationDao = donationDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Donation> getAllByUser(int userid) {
        return donationDao.getAllByUser(userid);
    }

    @Override
    public void save(Donation donation) {
        donationDao.save(donation);
    }

    @Override
    public Donation get(int id) {
        return donationDao.get(id);
    }

    @Override
    public void update(Donation donation) {
        donationDao.update(donation);
    }

    @Override
    public void delete(int id) {
        donationDao.delete(id);
    }

}
