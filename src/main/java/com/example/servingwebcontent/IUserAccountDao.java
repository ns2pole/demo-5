package com.example.servingwebcontent;
 
import com.example.servingwebcontent.model.User;

import java.util.Optional;
 
public interface IUserAccountDao {
    // Userを取得
    Optional<User> findUserBy(String name);
}