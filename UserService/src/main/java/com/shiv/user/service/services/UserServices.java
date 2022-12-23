package com.shiv.user.service.services;

import com.shiv.user.service.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String id);

    User UpdateUser(User user);

    void DeleteUser(String id);


}
