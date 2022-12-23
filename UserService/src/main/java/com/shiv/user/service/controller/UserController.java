package com.shiv.user.service.controller;

import com.shiv.user.service.entities.User;
import com.shiv.user.service.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;


    //create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User Newuser = userServices.saveUser(user);
        return new ResponseEntity<User>(Newuser , HttpStatus.CREATED);
    }

    //single

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        User Newuser = userServices.getUser(id);
        return new ResponseEntity<User>(Newuser , HttpStatus.OK);
    }


    //All

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> Newuser = userServices.getAllUser();
        return new ResponseEntity<List<User>>(Newuser , HttpStatus.OK);
    }

    @PutMapping("/newUser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User Newuser = userServices.UpdateUser(user);
        return new ResponseEntity<User>(Newuser , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        userServices.DeleteUser(id);
        return new ResponseEntity<String>("User Deleted Successfully !!!" , HttpStatus.OK);
    }


}
