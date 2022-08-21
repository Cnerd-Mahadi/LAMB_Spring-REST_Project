package com.daos;

import com.models.User;

import java.util.List;

public interface UserDao {

    public List<User> getAll();

    public List<User> uniqueCheckMaterials();

    public void save(User user);

    public User getWithCred(int id);

    public User get(int id);

    public User getByEmail(String email);

    public User findByLoginAndPassword(String login, String password);

    public void update(User user);


    public void delete(int id);

}
