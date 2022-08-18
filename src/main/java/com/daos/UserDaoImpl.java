package com.daos;

import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        List<User> users = userQuery.getResultList();
        return users == null ? new ArrayList<User>() : users;
    }

    @Override
    public List<User> uniqueCheckMaterials() {
        Session session = this.sessionFactory.getCurrentSession();
        Query userQuery = session.createQuery("select u.email, u.username from User u");
        List<User> users = userQuery.getResultList();
        return users == null? new ArrayList<User>() : users;
    }


    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getWithCred(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query userQuery = session.createQuery("select u.userId, u.email, u.username, u.role, u.phone, u.area from User u");
        return (User)userQuery.getSingleResult();
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void delete(int id) {
        User user = get(id);
        sessionFactory.getCurrentSession().delete(user);
    }


}
