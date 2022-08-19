package com.daos;

import com.models.History;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryDaoImpl implements HistoryDao {

    private final SessionFactory sessionFactory;

    public HistoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<History> getVisitorHistory(int userid) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<History> historyQuery = session.createQuery("from History h where h.requestId = :requestId", History.class);
        historyQuery.setParameter("requestId", userid);
        List<History> histories = historyQuery.getResultList();
        return histories == null ? new ArrayList<History>() : histories;
    }

    @Override
    public List<History> getDonorHistory(int userid) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<History> historyQuery = session.createQuery("from History h where h.donorId = :donorId", History.class);
        historyQuery.setParameter("donorId", userid);
        List<History> histories = historyQuery.getResultList();
        return histories == null ? new ArrayList<History>() : histories;
    }


    @Override
    public void save(History history) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(history);
    }

    @Override
    public History get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(History.class, id);
    }

    @Override
    public void update(History history) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(history);
    }

    @Override
    public void delete(int id) {
        History history = get(id);
        sessionFactory.getCurrentSession().delete(history);
    }

}
