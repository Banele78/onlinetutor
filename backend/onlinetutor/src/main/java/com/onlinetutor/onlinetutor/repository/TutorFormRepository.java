package com.onlinetutor.onlinetutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinetutor.onlinetutor.model.TutorForm;
import com.onlinetutor.onlinetutor.model.User;

@Repository
public interface TutorFormRepository extends JpaRepository<TutorForm, Long> {

    Optional<TutorForm> findByUser(User user);

}
