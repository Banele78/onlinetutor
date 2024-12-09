package com.onlinetutor.onlinetutor.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is required")
   
    private String password;

    @NotBlank(message = "Sign-up role is required")
    private String signUpAs; // Updated variable name

     @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
     @JsonIgnoreProperties("user")
    private TutorForm registrationForm;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignUpAs() {
        return signUpAs;
    }

    public void setSignUpAs(String signUpAs) {
        this.signUpAs = signUpAs;
    }

    public TutorForm getRegistrationForm() {
        return registrationForm;
    }

    public void setRegistrationForm(TutorForm registrationForm) {
        this.registrationForm = registrationForm;
        if (registrationForm != null) {
            registrationForm.setUser(this); // Ensure both sides of the relationship are in sync
        }
    }

    
}
