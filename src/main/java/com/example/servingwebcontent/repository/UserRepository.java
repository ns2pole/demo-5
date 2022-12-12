package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByName(String name);

//    Optional<User> findById(String id);
//    User save(User user);
//    void deleteById(String id);
//    User findByUsernameEquals(String username);

    // @Autowired
    // private NamedParameterJdbcTemplate jdbcTemplate;
        
    // public Optional<User> findUserBy(String name) {
    //     String sql = "SELECT id, password, role, name " + "FROM users " + "WHERE name = :name";
    //     Map<String, Object> param = new HashMap<>();
    //     param.put("name", name);
    //     User user = new User();
    //     try {
    //         Map<String, Object> result = this.jdbcTemplate.queryForMap(sql, param);
    //         user.setId((int) result.get("id"));
    //         user.setPassword((String)result.get("password"));
    //         user.setName((String)result.get("name"));
    //         user.setRole((String)result.get("role"));
    //     } catch(EmptyResultDataAccessException e){
    //         Optional <User> userOpl = Optional.ofNullable(user);
    //         return userOpl;
    //     }
    //     // ラップする
    //     Optional <User> userOpl = Optional.ofNullable(user);
    //     return userOpl;
    // }
}