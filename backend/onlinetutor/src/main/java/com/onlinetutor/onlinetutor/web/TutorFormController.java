package com.onlinetutor.onlinetutor.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.onlinetutor.onlinetutor.DTO.TutorFormRequestDTO;
import com.onlinetutor.onlinetutor.Service.TutorFormService;
import com.onlinetutor.onlinetutor.Service.UserService;
import com.onlinetutor.onlinetutor.auth.AuthInterceptor;
import com.onlinetutor.onlinetutor.model.TutorForm;
import com.onlinetutor.onlinetutor.model.User;

import jakarta.validation.Valid;

@RestController
public class TutorFormController {

    @Autowired
    private TutorFormService tutorFormService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthInterceptor authInterceptor;

  //Register user
      @PostMapping("/api/tutorForm")
    public ResponseEntity<String> creatForm(@Valid @ModelAttribute TutorFormRequestDTO formDTO, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }
             
        // Validate and process fields       
        MultipartFile identityDoc = formDTO.getIdentityDoc();
        MultipartFile scoreReportDoc = formDTO.getScoreReportDoc();

        if (identityDoc == null || identityDoc.isEmpty()) {
            return ResponseEntity.badRequest().body("Identity document is required");
        }

        if (scoreReportDoc == null || scoreReportDoc.isEmpty()) {
            return ResponseEntity.badRequest().body("Score report document is required");
        }

        // Process files (e.g., save to storage or convert to bytes)
        byte[] identityDocBytes = identityDoc.getBytes();
        byte[] scoreReportDocBytes = scoreReportDoc.getBytes();

        // Persist data to the database (convert DTO to entity)
        TutorForm tutorForm = new TutorForm();
        tutorForm.setfName(formDTO.getfName());
        tutorForm.setlName(formDTO.getlName());
        tutorForm.setPhoneNo(formDTO.getPhoneNo());
        tutorForm.setNationalId(formDTO.getNationalId());
        tutorForm.setAdress(formDTO.getAdress());
        tutorForm.setAddress2(formDTO.getAddress2());
        tutorForm.setCity(formDTO.getCity());
        tutorForm.setPostalCode(formDTO.getPostalCode());
        tutorForm.setQualification(formDTO.getQualification());
        tutorForm.setAfStudy(formDTO.getAfStudy());
        tutorForm.setExperience(formDTO.getExperience());
        tutorForm.sethRate(formDTO.gethRate());

        tutorForm.setIdentityDoc(identityDoc.getOriginalFilename());
        tutorForm.setIdentityDocContentType(identityDoc.getContentType());
        tutorForm.setIdentityDocBytes(identityDocBytes);

        tutorForm.setScoreReportDoc(scoreReportDoc.getOriginalFilename());
        tutorForm.setScoreReportDocContentType(scoreReportDoc.getContentType());
        tutorForm.setScoreReportDocBytes(scoreReportDocBytes);

        tutorForm.setTsCs(formDTO.getTsCs());
        // Map other fields...

        // Save tutorForm to the database (assume you have a service or repository)
        tutorFormService.saveForm(tutorForm);
        return ResponseEntity.ok("User registered successfully");
    } 
    
    
    @GetMapping("/api/getTutorForm")
    public ResponseEntity<TutorForm> getTutorForm(){
        Long userId = authInterceptor.getId();
        User user = userService.getUserById(userId);

        TutorForm tutorForm = tutorFormService.geTutorForm(user);
       
        return ResponseEntity.ok(tutorForm);
    }

}
