package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.dto.requests.create.CreateUserRequest;
import com.web2.bookbuzz.dto.requests.find.FindUserRequest;
import com.web2.bookbuzz.dto.requests.update.UpdateUserRequest;
import com.web2.bookbuzz.error.DuplicatedEntityException;
import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        try {
            FindUserRequest request = new FindUserRequest(name, email);
            return ResponseEntity.ok().body(userService.getAllUsers(request));
        } catch (Exception e) {
            throw e;
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(userService.getUserById(id));
        } catch (EntityNotFoundException e) {
            return e.getError();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody CreateUserRequest userModel) {
        try {
            return ResponseEntity.ok().body(userService.addUser(userModel));
        } catch (DuplicatedEntityException e) {
            return e.getError();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest userModel) {
        try {
            return ResponseEntity.ok().body(userService.updateUser(id, userModel));
        } catch (EntityNotFoundException e) {
            return e.getError();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return e.getError();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
