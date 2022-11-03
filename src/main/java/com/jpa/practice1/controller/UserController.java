package com.jpa.practice1.controller;

import com.jpa.practice1.domain.User;
import com.jpa.practice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userdata/v2/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> insertUser(@RequestBody User user){
    return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> getAllUsers(){
        return  new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @DeleteMapping(value = "/user/{studentEmail}")
    public ResponseEntity<?> deleteUser(@PathVariable String studentEmail){
        return  new ResponseEntity<>(userService.deleteUserByEmail(studentEmail),HttpStatus.OK);
    }

    @GetMapping("/user/{firstName}")
    public ResponseEntity<?> getByFirstName(@PathVariable String firstName ){
        return new ResponseEntity<>(userService.getUserByFirstName(firstName),HttpStatus.OK);
    }

    @PutMapping("/user/{studentEmail}")
    public ResponseEntity<?> updateStudentEmail(@RequestBody  User user,@PathVariable String studentEmail){
       return new ResponseEntity<>(userService.updateUser(user,studentEmail),HttpStatus.OK);
    }
}
