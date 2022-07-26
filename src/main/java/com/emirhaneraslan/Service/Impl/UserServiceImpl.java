package com.emirhaneraslan.Service.Impl;

import com.emirhaneraslan.Model.User;
import com.emirhaneraslan.Repository.UserRepository;
import com.emirhaneraslan.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User AddUser(User user) {
        if (!user.getUserMail().contains("@")) {
            return null;
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public ResponseEntity<User> getUserById(long userId) {
        User user = (User) entityManager
                .createNamedQuery("User.findById")
                .setParameter("userId",userId)
                .getSingleResult();
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<Map<String,Boolean>> deleteUser(long userId) {
        userRepository.deleteById(userId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<User> getAllUser() {
        List<User> list= (List<User>) entityManager.createNamedQuery("User.findAll").getResultList();
        return list;
    }

    @Override
    public ResponseEntity<List<User>> getUserByFirstName(String name) {
        List<User> list= (List<User>) entityManager.createNamedQuery("User.findByUserFirstName").setParameter("userFirstName",name).getResultList();
        return ResponseEntity.ok(list);
    }
}
