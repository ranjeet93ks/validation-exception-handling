package com.exception.handling.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exception.handling.api.dto.UserRequest;
import com.exception.handling.api.entity.User;
import com.exception.handling.api.exception.UserNotFoundException;
import com.exception.handling.api.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    
    //http://localhost:9292/h2-console/ to see in-memory db o/p on screen

    @PostMapping("/signup")
    //http://localhost:9292/users/signup
    //{     "name": "",     "email" : "@gmail.com",     "mobile": 545,     "gender":"Male",     "age": 4564,     "nationality":null }
    
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getALlUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
}
