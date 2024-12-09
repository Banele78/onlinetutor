package com.onlinetutor.onlinetutor.Service;

import org.springframework.stereotype.Service;

import com.onlinetutor.onlinetutor.DTO.UserLoginDTO;



@Service
public class loginService {

    public static String getToken() {
        // Validate or process the DTO data as needed
        return UserLoginDTO.getToken();
    }
}

