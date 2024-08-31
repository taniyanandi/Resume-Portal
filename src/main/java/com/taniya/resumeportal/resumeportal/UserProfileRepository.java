package com.taniya.resumeportal.resumeportal;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.taniya.resumeportal.resumeportal.models.User;
import com.taniya.resumeportal.resumeportal.models.UserProfile;

import java.beans.JavaBean;
import java.util.List;
@Repository
@Configuration
@Component
@Controller("JpaRepository")

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    //void save(User user);
    Optional<UserProfile> findByUserName(String userName);

    void save(User user);
}
