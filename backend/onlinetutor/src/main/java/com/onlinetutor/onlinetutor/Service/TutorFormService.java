package com.onlinetutor.onlinetutor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutor.onlinetutor.auth.AuthInterceptor;
import com.onlinetutor.onlinetutor.model.TutorForm;
import com.onlinetutor.onlinetutor.model.User;
import com.onlinetutor.onlinetutor.repository.TutorFormRepository;

@Service
public class TutorFormService {

    @Autowired
    private TutorFormRepository tutorFormRepository;

    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private UserService userService;

    public TutorForm geTutorForm(User user){
      return tutorFormRepository.findByUser(user).orElse(null);

    }

    public TutorForm saveForm(TutorForm form){
      Long userId = authInterceptor.getId();
      User user = userService.getUserById(userId);

      form.setUser(user);
      return  tutorFormRepository.save(form);

    }

}
