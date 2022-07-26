package com.emirhaneraslan.Controller.Impl;

import com.emirhaneraslan.Controller.IUserRest;
import com.emirhaneraslan.Model.User;
import com.emirhaneraslan.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserRestImpl implements IUserRest {

    @Autowired
    IUserService iUserService;

    @Override
    @PostMapping("create")
    public User createUser(@RequestBody User user) {
        return iUserService.AddUser(user);
    }

    @Override
    @GetMapping("findAll")
    public List<User> getAllUser() {
        return iUserService.getAllUser();
    }

    @Override
    @GetMapping("getbyid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id) {
        return iUserService.getUserById(id);
    }

    @Override
    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return iUserService.updateUser(user);
    }

    @Override
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable(name = "id") Long id) {
        return iUserService.deleteUser(id);
    }

    @Override
    @GetMapping("findbyname")
    public ResponseEntity<List<User>> getUserByFirstName(String name) {
        return iUserService.getUserByFirstName(name);
    }
}
