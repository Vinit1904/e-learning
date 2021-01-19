package com.cdac.elearning.controller;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.elearning.service.AuthenticationResponse;
import com.cdac.elearning.service.userService;

import io.jsonwebtoken.security.InvalidKeyException;
import net.bytebuddy.utility.RandomString;

import com.cdac.elearning.config.EmailCfg;

import com.cdac.elearning.model.User;;


@RestController
@CrossOrigin
public class userController {

	@Autowired
	private userService userServ;
	
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
   

	@Autowired
	private MailSender mailSender;
	
    @Autowired
    private EmailCfg emailCfg;
    
    
	@RequestMapping("/welcome")
	public String User()
	{		
		System.out.print("ss");
		return "hello";		
	}
	
	@PostMapping("/create_user")
	public String createUser(@RequestBody User user)
	{	
		try {	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("role_user");
		
        userServ.createUser(user);
	}
	catch(org.springframework.dao.DuplicateKeyException e){
		return "exception";
	}
        return "Sucesss";
	}
	
	
	@PostMapping("/logina")
    public AuthenticationResponse login(@RequestBody User loginRequest) throws InvalidKeyException {
		
		return userServ.login(loginRequest);		
    }
	
	

	
	@GetMapping("/home")
    public String home() {
        
		return "home";
    }
	
	@GetMapping("/auth")
    public String auth() {
        
		return "auty";
    }
	
	@GetMapping("/admin")
    public String admin() {
        
		return "admin";
    }
	
	@GetMapping("/logout_success")
    public String logout_success() {
		
        return "logout2";
    }
	
	
	@PostMapping("/forgot_password")
    public String processForgotPassword(@RequestBody User loginRequest) throws UnsupportedEncodingException, MessagingException {
		String emailId=loginRequest.getEmailId();
		String token = RandomString.make(30);
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());
       

        Properties mailProps = new Properties();
        mailProps.put("mail.smtps.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");
        mailProps.put("mail.smtp.debug", "true");
        
        mailSender.setJavaMailProperties(mailProps);

	    
	       userServ.updateResetPasswordToken(token, emailId);
	       String resetPasswordLink = "http://localhost:3000/ForgotPass?token=" + token;
	          
	      MimeMessage message = mailSender.createMimeMessage();
	       MimeMessageHelper helper = new MimeMessageHelper(message);
			  
			  helper.setFrom("vinitsarode86@gmail.com", "E-learning Support");
			  helper.setTo(emailId);
			  
			  String subject = "Here's the link to reset your password";
			  
			  String content = "<p>Hello,</p>" +
			  "<p>You have requested to reset your password.</p>" +
			  "<p>Click the link below to change your password:</p>" + "<p><a href=\"" +
			  resetPasswordLink + "\">Change my password</a></p>" + "<br>" +
			  "<p>Ignore this email if you do remember your password, " +
			  "or you have not made the request.</p>";
			  
			  helper.setSubject(subject);
			  
			  helper.setText(content, true);
			 
			  mailSender.send(message);

			  
		return "vv";
    }
     
	  
	  @PostMapping("/reset_password")
	  public String processResetPassword(@RequestBody User user) {
	      String token = user.getReset_password_token();
	      String password = user.getPassword();
	       
	      User users = userServ.getByResetPasswordToken(token);
	      
	      if (users == null) {
	    	  
	          
	          return "message1";
	      } else {           
	          userServ.updatePassword(users, password);
	      }
	       
	      return "message";
	  }
    
}
