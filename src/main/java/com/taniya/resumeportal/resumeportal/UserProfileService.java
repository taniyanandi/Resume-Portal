package com.taniya.resumeportal.resumeportal;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Retry.Topic;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.taniya.resumeportal.resumeportal.models.UserProfile;

@Component
@Service
public class UserProfileService {

    
    UserProfileRepository userProfileRepository;

    public void UserProfileService(UserProfileRepository userProfileRepository)
    {
        this.userProfileRepository=userProfileRepository;
    }
    public void addTopic(UserProfile userProfile) 
    {
        userProfileRepository.save(userProfile);
        
    }

}
