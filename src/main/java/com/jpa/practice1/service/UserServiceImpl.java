package com.jpa.practice1.service;

import com.jpa.practice1.domain.User;
import com.jpa.practice1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String studentEmail) {
        Optional<User> opUser = userRepository.findById(studentEmail);
        if(opUser.isEmpty()){
            return null;
        }
        User existingUser = opUser.get();
        if(user.getFirstName()!= null){
            existingUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!= null){
            existingUser.setLastName(user.getLastName());
        }

        if(user.getPassword()!= null){
            existingUser.setPassword(user.getPassword());
        }

        return userRepository.save(existingUser) ;
    }

    @Override
    public boolean deleteUserByEmail(String studentEmail) {

        userRepository.deleteById(studentEmail);
         return true;
    }

    @Override
    public List<User> getUserByFirstName(String firstname) {
        return userRepository.findByFirstName(firstname);
    }
}
