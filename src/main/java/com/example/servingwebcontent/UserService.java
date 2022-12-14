package com.example.servingwebcontent;
 
import java.util.Optional;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public User loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name)
            .orElseThrow(() -> new UsernameNotFoundException(name + " not found"));
        return user;
    }

}