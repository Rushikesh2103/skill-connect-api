//package com.skillconnect.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.skillconnect.model.User;
//import com.skillconnect.response.JwtResponse;
//import com.skillconnect.service.UserService;
//import com.skillconnect.utility.JwtUtil;
//
//@RestController
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> verifyUser(@RequestBody User user) {
//        User foundUser = userService.findByEmail(user.getEmail());
//        
//        if (foundUser == null) {
//            return ResponseEntity.notFound().build();
//        }
//        
//        if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
//            String token = jwtUtil.generateToken(foundUser.getEmail());
//            return ResponseEntity.ok(new JwtResponse(token));
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//}
