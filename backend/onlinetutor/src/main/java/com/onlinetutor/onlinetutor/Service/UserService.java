package com.onlinetutor.onlinetutor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutor.onlinetutor.model.User;
import com.onlinetutor.onlinetutor.repository.UserRepository;
import com.onlinetutor.onlinetutor.utility.PasswordUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    } 

    public User saveUser(User user){
         user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

}
