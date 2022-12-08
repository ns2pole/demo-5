package com.example.servingwebcontent;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.servingwebcontent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDao implements IUserAccountDao {


    private final NamedParameterJdbcTemplate jdbcTemplate;
     
    @Autowired
    public UserAccountDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
     
    @Override
    public Optional<User> findUser(String username) {
        
        String sql = "SELECT id, password, auth, user_name " + "FROM users " + "WHERE user_name = :user_name";
        Map<String, Object> param = new HashMap<>();
        param.put("user_name", username);
        User user = new User();
        try {
            Map<String, Object> result = this.jdbcTemplate.queryForMap(sql, param);
            user.setId((int) result.get("id"));
            user.setPassword((String)result.get("password"));
            user.setName((String)result.get("user_name"));
            user.setAuth((String)result.get("auth"));
        } catch(EmptyResultDataAccessException e){
            Optional <User> userOpl = Optional.ofNullable(user);
            return userOpl;
        }
         
        // ラップする
        Optional <User> userOpl = Optional.ofNullable(user);
        return userOpl;
    }
}