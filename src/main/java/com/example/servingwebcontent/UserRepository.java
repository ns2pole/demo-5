package com.example.servingwebcontent;

import java.util.Optional;

/**
 * インフラ層とのインタフェース
 */
public interface UserRepository {

    Optional<User> findById(String id);

    User save(User user);

    void deleteById(String id);

    User findByUsernameEquals(String username);
}