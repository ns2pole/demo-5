package com.example.servingwebcontent;

import com.example.servingwebcontent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

//    Optional<User> findById(String id);
//
//    User save(User user);
//
//    void deleteById(String id);
//
//    User findByUsernameEquals(String username);
}