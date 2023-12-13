package com.example.servingwebcontent;
 
import java.util.Optional;

import com.example.servingwebcontent.model.Division;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.DivisionRepository;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    DivisionRepository divisionRepository;




    public String getDivisionNameBy(int user_id) {
        User user = userRepository.findById(user_id);
        Division division = divisionRepository.findById(user.getDivisionId()).get();
        return division.getName();
    }
}