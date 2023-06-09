package com.backend.services;

import com.backend.models.User;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository UserRepository;
    @Override
    public void createOrUpdateUser(User user) {
        UserRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = UserRepository.findAll();
        return list;
    }

    @Override
    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return UserRepository.findById(id).get();
    }

    @Override
    public User editUser(Long id) {
        return UserRepository.getOne(id);
    }
}
