package com.emirhaneraslan.Controller;

import com.emirhaneraslan.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserRest {

    User createUser(User user);

    List<User> getAllUser();

    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<User> updateUser(User user);

    ResponseEntity<Map<String,Boolean>> deleteUser(Long id);

    ResponseEntity<List<User>> getUserByFirstName(String name);
}
