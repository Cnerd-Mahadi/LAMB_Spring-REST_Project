package com.daos;

import com.models.Donor;
import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DonorDaoImpl implements DonorDao {

    private final SessionFactory sessionFactory;

    public DonorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Donor> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Donor> donorQuery = session.createQuery("from Donor", Donor.class);
        List<Donor> donors = donorQuery.getResultList();
        return donors == null ? new ArrayList<Donor>() : donors;
    }

    @Override
    public List<Donor> getAllByBlood(String bloodType) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Donor> donorQuery = session.createQuery("from Donor d where d.bloodType =:bloodType", Donor.class);
        donorQuery.setParameter("bloodType", bloodType);
        List<Donor> donors = donorQuery.getResultList();
        return donors == null ? new ArrayList<Donor>() : donors;
    }

    @Override
    public void save(Donor donor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(donor);
    }

    @Override
    public Donor get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Donor.class, id);
    }

    @Override
    public Donor getDonorEligibility(int userid) {
        Session session = this.sessionFactory.getCurrentSession();
        Query donorQuery = session.createQuery("select d.eligibility, d.lastDonate from Donor d where d.userFK = :uid");
        donorQuery.setParameter("uid", userid);
        Object[] obj = (Object[]) donorQuery.uniqueResult();
        Donor donor = new Donor();

        donor.setEligibility(obj[0].toString());
        donor.setLastDonate(obj[1].toString());
        return donor;
    }

    @Override
    public void update(Donor donor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(donor);
    }

    @Override
    public void delete(int id) {
        Donor donor = get(id);
        sessionFactory.getCurrentSession().delete(donor);
    }

}
