package com.services;

import com.daos.PostDao;
import com.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAll() {
        return postDao.getAll();
    }

    @Override
    public List<Post> getPostByUser(int id) {
        return postDao.getPostByUser(id);
    }

    @Override
    public void save(Post post) {
        postDao.save(post);
    }

    @Override
    public Post get(int id) {
        return postDao.get(id);
    }

    @Override
    public void update(Post post) {
        postDao.update(post);
    }

    @Override
    public void updateLastStatus(Post post) {
        postDao.updateLastStatus(post);
    }

    @Override
    public void delete(int id) {
        postDao.delete(id);
    }

}

