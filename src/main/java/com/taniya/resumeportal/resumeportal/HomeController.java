package com.taniya.resumeportal.resumeportal;

import java.security.Principal;
import java.util.*;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Retry.Topic;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taniya.resumeportal.resumeportal.models.Education;
import com.taniya.resumeportal.resumeportal.models.User;
import com.taniya.resumeportal.resumeportal.models.UserProfile;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

 @Autowired
 UserProfile user1; 

  
 // UserRepository userRepository;
  UserProfileRepository userProfileRepository;

    
    @Autowired
    UserProfileService userProfileService;

 public void HomeController(UserProfileRepository userProfileRepository) 
 {
      this.userProfileRepository = userProfileRepository;
      user1.setId(1);
      user1.setUserName("hello");
      userProfileRepository.save(user1);
      Education educations= new  Education();

      educations.setId(1);
      educations.setCollege("VIT");
  
 
     
}
List <UserProfile> profiles=new ArrayList<>();
List <Education> edu=new ArrayList<>();
List <String> skill= new ArrayList<>();


     
@GetMapping("/home")
public String home() {
    return "/index";
}
@RequestMapping(value="/start", method=RequestMethod.GET)
       public String populate(Model m) 
       {
       user1.setId(1);
       user1.setUserName("hello");
       user1.setFirstName("Taniya");
       user1.setLastName("Nandi");
       user1.setEmail("h.@g.com");
       user1.setPhone("6374867324");
       skill.add("Java");
       skill.add("SpringBoot");
       skill.add("Hibernate");
       user1.setSkills(skill);
       user1.setSummary("Strong Core Java developer with experience in the financial domain. Passionate about clean code, focused on delivering the product of the highest quality. Experienced with building distributed, high performing, concurrent and robust Java software.");
       user1.setDesignation("3+ years as a Java Developer ");
       
       
       Education educations= new  Education();
       educations.setId(1);
        educations.setCollege("VIT");
       edu.add(educations);
       user1.setEducations(edu);
       

       profiles.add(user1);
       //userProfileRepository.save(user1);
     


       if(userProfileRepository!=null)
        {
            userProfileRepository.findAll().forEach(profiles::add);
            userProfileRepository.save(user1);

        }
        m.addAttribute("user1", user1);
        m.addAttribute("educations", educations);
        m.addAttribute("edu", edu);
       // System.out.println("taniya"+userProfileRepository.count());
        return "profile-templates/" + 2 + "/index";
        


           
       }
       @RequestMapping(value="/save", method=RequestMethod.POST)
       public void postMethodName(@RequestBody UserProfile user)
        {
           profiles.add(user);
           
            if(userProfileRepository!=null)
        {
            userProfileRepository.save(user);

        }
        System.out.println("taniya"+userProfileRepository.count());
    }
        @GetMapping("/edit")
        public String edit(Model model) 
        {
          
   
          
            
          /*   if ("job".equals(add)) {
                user1.get;
            } else if ("education".equals(add)) {
                userProfile.getEducations().add(new Education());
            } else if ("skill".equals(add)) {
                userProfile.getSkills().add("");
            }
    */
            model.addAttribute("user1", user1);
            return "profile-edit";
        }
    
    @PostMapping("/edit")
    public String postEdit(Model model,  @ModelAttribute UserProfile userProfile) 
    {
        user1.setFirstName(userProfile.getFirstName());
        user1.setId(1);
       user1.setUserName("hello");
      // user1.setFirstName("Taniya");
       user1.setLastName(userProfile.getLastName());
       user1.setEmail("h.@g.com");
       user1.setPhone("6374867324");
       skill.add("Java");
       skill.add("SpringBoot");
       skill.add("Hibernate");
       user1.setSkills(skill);
       user1.setSummary("Strong Core Java developer with experience in the financial domain. Passionate about clean code, focused on delivering the product of the highest quality. Experienced with building distributed, high performing, concurrent and robust Java software.");
       user1.setDesignation("3+ years as a Java Developer ");
       
       
       Education educations= new  Education();
       educations.setId(1);
        educations.setCollege("VIT");
       edu.add(educations);
       user1.setEducations(edu);
       

       profiles.add(user1);

       model.addAttribute("user1", user1);
       model.addAttribute("educations", educations);
       model.addAttribute("edu", edu);
       // userProfileRepository.save(userProfile);
        return "profile-templates/" + 2 + "/index";
    }

       
       
       
  
      
    
     
  

   
       @RequestMapping(value="/view/{userId}", method=RequestMethod.GET)
      
    public String view(@PathVariable String userId, Model model) {
      
        //String userName = principal.getName();
        if(userProfileRepository!=null)
        {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));

        model.addAttribute("userId", userId);
        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        }
       // System.out.println(userProfile.getJobs());

       return "index";
     
    }

}
