package com.daos;

import com.models.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {

    private final SessionFactory sessionFactory;

    public PostDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Post> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Post> postQuery = session.createQuery("from Post order by postId desc", Post.class);
        List<Post> posts = postQuery.getResultList();
        return posts == null ? new ArrayList<Post>() : posts;
    }

    @Override
    public void save(Post post) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(post);
    }

    @Override
    public Post get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Post.class, id);
    }

    @Override
    public void update(Post post) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(post);
    }

    @Override
    public void delete(int id) {
        Post post = get(id);
        sessionFactory.getCurrentSession().delete(post);
    }

}