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
        List<Object[]> objs = userQuery.list();
        List<User> users = new ArrayList<User>();
        for(Object[] obj: objs){
            User user = new User();
            user.setEmail(obj[0].toString());
            user.setUsername(obj[1].toString());
            users.add(user);
        }
        return users;
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
        Query userQuery = session.createQuery("select u.userId, u.email, u.username, u.role, u.phone, u.area from User u where u.userId = :uid");
        userQuery.setParameter("uid", id);
        Object[] obj = (Object[]) userQuery.uniqueResult();
        User user = new User();

        user.setUserId((Integer) obj[0]);
        user.setUsername(obj[2].toString());
        user.setEmail(obj[1].toString());
        user.setRole(obj[3].toString());
        user.setPhone(obj[4].toString());
        user.setArea(obj[5].toString());
        return user;
    }


    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        Query userQuery = session.createQuery("UPDATE User u set u.username = :username, u.email = :email, u.phone = :phone, u.area = :area WHERE u.userId = :userId");
        userQuery.setParameter("username", user.getUsername());
        userQuery.setParameter("email", user.getEmail());
        userQuery.setParameter("phone", user.getPhone());
        userQuery.setParameter("area", user.getArea());
        userQuery.setParameter("userId", user.getUserId());
        userQuery.executeUpdate();
    }



    @Override
    public void delete(int id) {
        User user = get(id);
        sessionFactory.getCurrentSession().delete(user);
    }


}
