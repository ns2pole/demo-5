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
        
        String sql = "SELECT id, user_id, password, username "
                + "FROM users "
                + "WHERE username = :username";
        // パラメータ設定用Map
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
         
        User user = new User();
        // 一件取得
        try {
            System.out.println("UserAccountDao.findUser() is called.test    ");
            Map<String, Object> result = this.jdbcTemplate.queryForMap(sql, param);
            System.out.println(result);
            user.setId((int) result.get("id"));
            user.setUserId((String) result.get("user_id"));
            user.setPassword((String)result.get("password"));
            user.setName((String)result.get("username"));
        }catch(EmptyResultDataAccessException e){
            Optional <User> userOpl = Optional.ofNullable(user);
            return userOpl;
        }
         
        // ラップする
        Optional <User> userOpl = Optional.ofNullable(user);
        return userOpl;
    }
}