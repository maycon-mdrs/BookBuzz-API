package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<UserModel> getAllUsers(@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        return userService.getAllUsers(name, email);
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public void addUser(@RequestBody UserModel bookModel) {
        userService.addUser(bookModel);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserModel bookModel) {
        userService.updateUser(id, bookModel);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }


}
