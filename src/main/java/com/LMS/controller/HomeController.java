package com.LMS.controller;

import com.LMS.dto.UserDto;
import com.LMS.entity.User;
import com.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){

        User user=new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAuthority(userDto.getAuthority());

       return new ResponseEntity<>(this.userRepository.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) throws Exception {
        try{

           Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(),userDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }catch (BadCredentialsException e){
            throw new Exception("Invalid credentials");
        }
        return new ResponseEntity<>("Login is successfully ",HttpStatus.OK);
    }
}
