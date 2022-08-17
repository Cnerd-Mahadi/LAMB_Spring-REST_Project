package com.services;

import com.daos.UserDao;
import com.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> uniqueCheckMaterials() {
        return userDao.uniqueCheckMaterials();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAll(String firstName) {
        return userDao.getAll(firstName);
    }
}
