package com.shiv.user.service.services.impl;

import com.shiv.user.service.entities.User;
import com.shiv.user.service.exceptions.ResourceNotFoundException;
import com.shiv.user.service.repositories.UserRepositories;
import com.shiv.user.service.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public User saveUser(User user) {

        //Unique Id Generated
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);

        return userRepositories.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepositories.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !!1"+id));
    }

    @Override
    public User UpdateUser(User user) {
        return userRepositories.save(user);
    }

    @Override
    public void DeleteUser(String id) {

            User user = userRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !!1"+id));

            userRepositories.deleteById(id);
    }


}
