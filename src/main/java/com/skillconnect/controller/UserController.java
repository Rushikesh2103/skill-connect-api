package com.skillconnect.controller;

import com.skillconnect.dto.ClientDTO;

import com.skillconnect.dto.FreelancerDTO;
import com.skillconnect.dto.UserDTO;
import com.skillconnect.model.BusinessProfile;
import com.skillconnect.model.FreelancerProfile;
import com.skillconnect.model.User;
import com.skillconnect.service.BusinessProfileService;
import com.skillconnect.service.FreelancerProfileService;
import com.skillconnect.service.UserService;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/api/users")
public class UserController {

      @Autowired
      private UserService userService;
      @Autowired
      private FreelancerProfileService freelancerProfileService;
      
      @Autowired
      private BusinessProfileService businessProfileService;
  
      //get all users
      @GetMapping("/freelancers")
      public ResponseEntity<List<FreelancerDTO>> getAllProjects() {
          List<FreelancerProfile> freelancers = freelancerProfileService.getAllProfiles();
          List<FreelancerDTO> freelancerDTO = freelancers.stream().map(freelancer -> {
        	  FreelancerDTO dto = new FreelancerDTO();
              dto.setId(freelancer.getId());
              dto.setFirstName(freelancer.getFirstName());
              dto.setLastName(freelancer.getLastName());
              dto.setExperience(freelancer.getExperience());
              dto.setLocation(freelancer.getLocation());
              return dto;
          }).collect(Collectors.toList());

          return ResponseEntity.ok(freelancerDTO);
      }
      //get freelancer by id
      @GetMapping("freelancers/{id}")
      public ResponseEntity<FreelancerDTO> getFreelancerById(@PathVariable int id,HttpSession session) { 
          Optional<User> userOptional = userService.getUserById(id);

          if (userOptional.isPresent()) {
              User user = userOptional.get();

              // Assuming your User entity has a related FreelancerProfile entity with the needed details
              FreelancerDTO freelancerDTO = new FreelancerDTO();
              freelancerDTO.setId(user.getId());
              freelancerDTO.setFirstName(user.getFreelancerProfile().getFirstName());
              freelancerDTO.setLastName(user.getFreelancerProfile().getLastName());
              freelancerDTO.setLocation(user.getFreelancerProfile().getLocation());
              freelancerDTO.setExperience(user.getFreelancerProfile().getExperience());

              return ResponseEntity.ok(freelancerDTO);
          } else {
              return ResponseEntity.notFound().build();
          }
      }
//get client by id
      @GetMapping("client/{id}")
      public ResponseEntity<ClientDTO> getClientById(@PathVariable int id,HttpSession session) {
          //System.out.println(id + "idddddddddd");
          Optional<User> userOptional = userService.getUserById(id);

          if (userOptional.isPresent()) {
              User user = userOptional.get();

              // Assuming your User entity has a related FreelancerProfile entity with the needed details
              ClientDTO clientDTO = new ClientDTO();
              clientDTO.setId(user.getId());
              clientDTO.setCompany_name(user.getBusinessProfile().getCompany_name());
              clientDTO.setDescription(user.getBusinessProfile().getDescription());
              return ResponseEntity.ok(clientDTO);
          } else {
              return ResponseEntity.notFound().build();
          }
      }
      //register freelancer
      @PostMapping("/register/freelancers")
      public FreelancerProfile createFreelancer(@RequestBody FreelancerProfile freelancerProfile) {
    	  System.out.println(freelancerProfile.getUser());
          User user = userService.saveUser(freelancerProfile.getUser());
          
        
          freelancerProfile.setUser(user);
          
          return freelancerProfileService.saveProfile(freelancerProfile);
      }
      //register client
      @PostMapping("/register/client")
      public BusinessProfile createClient(@RequestBody BusinessProfile businessProfile) {
          
    	  System.out.println(businessProfile.getUser());
          User user = userService.saveUser(businessProfile.getUser());
          
         
          businessProfile.setUser(user);
          
          return businessProfileService.saveProfile(businessProfile);
      }

      
      @SuppressWarnings({ "unused", "unused" })
	@PostMapping("/login")
      public ResponseEntity<UserDTO> verifyUser(@RequestBody UserDTO user,HttpSession session) {
          // Fetch user by email
          User foundUser = userService.findByEmail(user.getEmail());
          System.out.println(user.getPassword()+"found"+foundUser.getPassword());
          // Check if the user exists
          if (foundUser == null) {
              return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // User not found
          }
     
         //check password
      if (user.getPassword().matches(foundUser.getPassword())) {
    	  System.out.println(user.getPassword()+"found"+foundUser.getPassword());
    	  	session.setAttribute("userId", foundUser.getId());
  			
  		// Create a UserDTO to return
          UserDTO userDto = new UserDTO();
          userDto.setId(foundUser.getId());
          userDto.setEmail(foundUser.getEmail());
          userDto.setRole(foundUser.getRole());

          return ResponseEntity.ok(userDto);
      }
      //invalid password
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
      
      }
      @GetMapping("/logout")
      public ResponseEntity<String> logoutUser(HttpSession session) {
      	session.invalidate();
      	System.out.println("Session ID in /login: " + session.getId()+" "+session.isNew());
          return ResponseEntity.ok("");
      }


  
      @PutMapping("/{id}")
      public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
          if (!userService.getUserById(id).isPresent()) {
              return ResponseEntity.notFound().build();
          }
          user.setId(id);
          return ResponseEntity.ok(userService.saveUser(user));
      }
  
      @DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteUser(@PathVariable int id) {
          if (!userService.getUserById(id).isPresent()) {
              return ResponseEntity.notFound().build();
          }
          userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
