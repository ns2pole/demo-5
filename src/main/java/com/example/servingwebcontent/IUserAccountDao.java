package com.example.servingwebcontent;
 
import java.util.Optional;
 
public interface IUserAccountDao {
    // Userを取得
    Optional<User> findUser(String userName);
}