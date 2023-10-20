package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://bookbuzz.italodea.com.br", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
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
    public ResponseEntity<UserModel> getUserById(@PathVariable int id) {
        verifyIfUserExists(id);
        UserModel user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
        verifyIfEmailExists(userModel.getEmail());
       return ResponseEntity.ok().body(userService.addUser(userModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable int id, @RequestBody UserModel userModel) {
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
