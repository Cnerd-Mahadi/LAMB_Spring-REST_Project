package com.daos;

import com.models.Post;

import java.util.List;

public interface PostDao {

    public List<Post> getAll();

    public void save(Post post);

    public Post get(int id);

    public void update(Post post);

    public void delete(int id);

}
