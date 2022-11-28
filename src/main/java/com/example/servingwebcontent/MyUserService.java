package com.example.servingwebcontent;
 
import java.util.Optional;
 
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
        System.out.println(userName);
        Optional<User> user = dao.findUser(userName);
        if(!user.isPresent()) {
            System.out.println("errorrrr");
            throw new UsernameNotFoundException(userName + "が存在しません");
        }   
        return new MyUserDetails(user.get());
    }

}