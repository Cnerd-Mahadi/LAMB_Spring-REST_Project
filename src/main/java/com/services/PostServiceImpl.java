package com.services;

import com.daos.PostDao;
import com.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostDao PostDao;

    public PostServiceImpl(PostDao postDao) {
        this.PostDao = postDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAll() {
        return PostDao.getAll();
    }

    @Override
    public void save(Post post) {
        PostDao.save(post);
    }

    @Override
    public Post get(int id) {
        return PostDao.get(id);
    }

    @Override
    public void update(Post post) {
        PostDao.update(post);
    }

    @Override
    public void delete(int id) {
        PostDao.delete(id);
    }

}

