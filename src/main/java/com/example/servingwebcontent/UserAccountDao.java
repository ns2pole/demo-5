package com.example.servingwebcontent;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
 
import com.example.servingwebcontent.User;
 
@Repository
public class UserAccountDao implements IUserAccountDao {


    private final NamedParameterJdbcTemplate jdbcTemplate;
     
    @Autowired
    public UserAccountDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
     
    @Override
    public Optional<User> findUser(String username) {
        
        String sql = "SELECT id, user_id, password, auth, username " + "FROM users " + "WHERE username = :username";
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        User user = new User();
        try {
            Map<String, Object> result = this.jdbcTemplate.queryForMap(sql, param);
            user.setId((int) result.get("id"));
            user.setUserId((String) result.get("user_id"));
            user.setPassword((String)result.get("password"));
            user.setName((String)result.get("username"));
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