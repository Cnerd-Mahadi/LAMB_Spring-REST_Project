package com.daos;

import com.models.Donation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DonationDaoImpl implements DonationDao {

    private final SessionFactory sessionFactory;

    public DonationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Donation> getAllByUser(int userid) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Donation> donationQuery = session.createQuery("from Donation d where d.donorId = :donorId", Donation.class);
        donationQuery.setParameter("donorId", userid);
        List<Donation> donations = donationQuery.getResultList();
        return donations == null ? new ArrayList<Donation>() : donations;
    }


    @Override
    public void save(Donation donation) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(donation);
    }

    @Override
    public Donation get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Donation.class, id);
    }

    @Override
    public void update(Donation donation) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(donation);
    }

    @Override
    public void delete(int id) {
        Donation donation = get(id);
        sessionFactory.getCurrentSession().delete(donation);
    }

}
