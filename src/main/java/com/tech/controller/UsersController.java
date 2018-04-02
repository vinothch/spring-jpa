package com.tech.controller;

import com.tech.model.Users;
import com.tech.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJpaRepository userJpaRepository;


    @GetMapping(value="/all")
    public List<Users> findAll() {

       return userJpaRepository.findAll();

    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name){
        return userJpaRepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users){

         userJpaRepository.save(users);
        return userJpaRepository.findByName(users.getName());
    }
}
