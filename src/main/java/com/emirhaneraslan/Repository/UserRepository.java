package com.emirhaneraslan.Repository;

import com.emirhaneraslan.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserId (Long userId);
}
