package com.taniya.resumeportal.resumeportal;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//import jakarta
import com.taniya.resumeportal.resumeportal.models.User;
import java.util.List;

@Repository
@Component
@Configuration
public interface UserRepository {
   
  //public void save(List<User> findByUserName(String userName);
    public Optional<User> findByUserName(String userName) ;

    public void save(User user);

   // public void add(User user);
    


}
