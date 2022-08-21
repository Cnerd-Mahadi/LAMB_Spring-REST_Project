package com.services;

import com.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public List<User> uniqueCheckMaterials();

    public void save(User user);

    public User get(int id);

    public User getByEmail(String email);

    public User getWithCredByEmail(String email);

    public User findByLoginAndPassword(String login, String password);

    public void update(User user);

    public void delete(int id);

}
