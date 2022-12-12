package com.example.servingwebcontent;

import com.example.servingwebcontent.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

//    Optional<User> findById(String id);
//    User save(User user);
//    void deleteById(String id);
//    User findByUsernameEquals(String username);
}