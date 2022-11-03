package com.jpa.practice1.service;

import com.jpa.practice1.domain.User;

import java.util.List;

public interface UserService {

    User  addUser(User user);
    List<User> getAllUser();
    User updateUser(User user,String studentEmail);
    boolean deleteUserByEmail(String studentEmail);
    List<User> getUserByFirstName(String firstname);


}
