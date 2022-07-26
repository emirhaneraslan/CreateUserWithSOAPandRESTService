package com.emirhaneraslan.Service;

import com.emirhaneraslan.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserService {

    public User AddUser(User user);

    public ResponseEntity<User> getUserById(long userId);

    public ResponseEntity<User> updateUser(User user);

    ResponseEntity<Map<String,Boolean>> deleteUser(long userId);

    public List<User> getAllUser();

    public ResponseEntity<List<User>> getUserByFirstName(String name);
}
