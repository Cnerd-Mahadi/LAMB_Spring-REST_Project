package com.daos;

import com.models.Visitor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitorDaoImpl implements VisitorDao {

    private final SessionFactory sessionFactory;

    public VisitorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Visitor> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Visitor> visitorQuery = session.createQuery("from Visitor", Visitor.class);
        List<Visitor> visitors = visitorQuery.getResultList();
        return visitors == null ? new ArrayList<Visitor>() : visitors;
    }

    @Override
    public void save(Visitor visitor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(visitor);
    }

    @Override
    public Visitor get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Visitor.class, id);
    }

    @Override
    public void update(Visitor visitor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(visitor);
    }

    @Override
    public void delete(int id) {
        Visitor visitor = get(id);
        sessionFactory.getCurrentSession().delete(visitor);
    }


}
