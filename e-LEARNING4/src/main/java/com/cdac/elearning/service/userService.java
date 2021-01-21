package com.cdac.elearning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.elearning.dto.Login;
import com.cdac.elearning.model.User;
import com.cdac.elearning.repository.userRepository;
import com.cdac.elearning.security.JwtProvider;

import io.jsonwebtoken.security.InvalidKeyException;

@Service
public class userService {

	@Autowired
	private userRepository userRepo;
	
	 @Autowired
	   private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 
	 @Autowired
	  private JwtProvider jwtProvider;
	
	public void createUser(User user)
	{
		 User isUserPresent = userRepo.findByEmail(user.getEmailId());
		 if(isUserPresent == null) {
			userRepo.save(user);
		 }
		 else
			 throw new DuplicateKeyException("User Already Present");
	}
	
	
	
	 public AuthenticationResponse login(Login loginRequest) throws InvalidKeyException {
	       
		 try {
		 Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmailId(),
	                loginRequest.getPassword()));
	        System.out.print(authenticate);
	       SecurityContextHolder.getContext().setAuthentication(authenticate);
	        String authenticationToken = jwtProvider.generateToken(authenticate);
	        
	        User userDeatails = userRepo.findByEmail(loginRequest.getEmailId());
	        
	        return new AuthenticationResponse(authenticationToken,userDeatails.getFirstName());
		 }
		 catch(UsernameNotFoundException e) {
			 throw new UsernameNotFoundException("User not Found");
		 }
		 catch(BadCredentialsException e) {
			 throw new BadCredentialsException("Bad Credentials");
		 }
	  }
	 
	 
//	 public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
//	        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
//	                getContext().getAuthentication().getPrincipal();
//	        return Optional.of(principal);
//	    }
	 

	 
	 
	 public void updateResetPasswordToken(String token, String email)  {
	        User user = userRepo.findByEmail(email);
	        if (user != null) {
	            user.setReset_password_token(token);
	            userRepo.save(user);
	        }
	    }
	     
	 
	    public User getByResetPasswordToken(String token) {
	        return userRepo.findByResetPasswordToken(token);
	    }
	   
	    
	    public void updatePassword(User user, String newPassword) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(newPassword);
	        user.setPassword(encodedPassword);
	         
	        user.setReset_password_token(null);
	        userRepo.save(user);
	    }

}
