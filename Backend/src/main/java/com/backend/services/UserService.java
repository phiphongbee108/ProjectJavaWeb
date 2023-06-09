package com.backend.services;

import com.backend.models.User;

import java.util.List;

public interface UserService {

    public void createOrUpdateUser(User user);

    public List<User> getAllUser();

    public void deleteUser(Long id);

    public User getUser(Long id);

    public User editUser(Long id);
}
