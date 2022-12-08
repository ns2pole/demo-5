package com.example.servingwebcontent;
 
import java.util.Optional;

import com.example.servingwebcontent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    private final IUserAccountDao dao;
    
    @Autowired
    public MyUserService(IUserAccountDao dao) {
        this.dao = dao;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("loadUserByUsernamecalled??");
        Optional<User> user = dao.findUser(userName);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException(userName + "が存在しません");
        }   
        return new MyUserDetails(user.get());
    }

}