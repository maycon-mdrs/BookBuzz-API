package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.dto.requests.find.FindUserRequest;
import com.web2.bookbuzz.dto.responses.UserResponseDTO;
import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        try {
            FindUserRequest request = new FindUserRequest(name, email);
            return ResponseEntity.ok().body(userService.getAllUsers(request));
        } catch (Exception e){
            throw e;
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        verifyIfUserExists(id);
        UserModel user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/")
        public ResponseEntity<?> addUser(@RequestBody UserModel userModel) {
        verifyIfEmailExists(userModel.getEmail());
       return ResponseEntity.ok().body(userService.addUser(userModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserModel userModel) {
        verifyIfUserExists(id);
        verifyIfEmailExists(userModel.getEmail());
        return ResponseEntity.ok().body(userService.updateUser(id, userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        verifyIfUserExists(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private void verifyIfUserExists(int id){
        if(userService.getUserById(id) == null){
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    }

    private void verifyIfEmailExists(String email){
        if(userService.getUserByEmail(email) != null){
            throw new EntityNotFoundException("Usuário com esse email já existe");
        }
    }

}
