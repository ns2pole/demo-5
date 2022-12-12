package com.example.servingwebcontent;
 
import java.util.Optional;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(name);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException(name + "が存在しません");
        }
        return new MyUserDetails(user.get());
    }

}