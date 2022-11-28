package com.example.servingwebcontent;
 
import java.util.Optional;
 
import com.example.servingwebcontent.User;

public interface IUserAccountDao {
    // Userを取得
    Optional<User> findUser(String userName);
}