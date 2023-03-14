package com.solutil.comercioapi.auth.controllers;

import com.solutil.comercioapi.auth.model.User;
import com.solutil.comercioapi.auth.repositories.UserRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/auth") // This means URL's start with /demo (after Application path)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/users")
    public @ResponseBody User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping(path = "/users")
    public @ResponseBody List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @DeleteMapping(path = "/users")
    public @ResponseBody String deleteAllUsers() {
        userRepository.deleteAll();
        return "deleted all";
    }

    @DeleteMapping(path = "/users/:id")
    public @ResponseBody String deleteAllUsers(@Validated @PathParam("id") int id) {
        userRepository.deleteById(id);
        return "deleted ${id}";
    }
}