package com.onlinetutor.onlinetutor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.onlinetutor.onlinetutor.DTO.UserLoginDTO;
import com.onlinetutor.onlinetutor.Service.UserService;
import com.onlinetutor.onlinetutor.auth.JwtService;
import com.onlinetutor.onlinetutor.model.User;
import com.onlinetutor.onlinetutor.utility.PasswordUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    //Register user
      @PostMapping("/api/register")
    public ResponseEntity<String> creatUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }

      // Check if a user with the given email already exists
    if (userService.getUserByEmail(user.getEmail()) != null) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
    }

        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }



     @PostMapping("/api/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO loginDTO, HttpServletResponse response) {
        // Fetch the user by email
        User user = userService.getUserByEmail(loginDTO.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    
        // Check if the password matches
        if (!PasswordUtil.matchPassword(loginDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }

         // Authenticate user and generate JWT token
        String token = jwtService.generateToken(String.valueOf(user.getId()));
        loginDTO.setToken(token);
      // Create the cookie
    Cookie cookie = new Cookie("authToken", token);
    cookie.setHttpOnly(true);
    cookie.setSecure(false); // 'true' for HTTPS in production
    cookie.setPath("/");
    cookie.setMaxAge(10 * 24 * 60 * 60); // 1 week expiry
    cookie.setDomain("localhost"); // Use the appropriate domain in production
    cookie.getValue();

    // Add the cookie (basic attributes)
    response.addCookie(cookie);

//    // Add the SameSite=None manually with all attributes
   String sameSiteCookie = String.format(
    "%s=%s; Path=%s; HttpOnly; Secure=%b; SameSite=None; Max-Age=%d; Domain=%s",
    cookie.getName(),
    cookie.getValue(),
    
    cookie.getPath(),
   cookie.getSecure(),
    cookie.getMaxAge(),
    cookie.getDomain()
);

// Overwrite the Set-Cookie header
response.setHeader("Set-Cookie", sameSiteCookie);

        return ResponseEntity.ok("Login successful" );
    }

}
