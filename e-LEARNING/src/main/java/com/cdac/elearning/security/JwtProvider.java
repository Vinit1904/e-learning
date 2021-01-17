package com.cdac.elearning.security;

import java.security.Key;

import javax.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Service;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
	private Key key;

    @PostConstruct
    public void init() {
       key = Keys.secretKeyFor(SignatureAlgorithm.HS512); 

    }

    public String generateToken(Authentication authentication) {
        //User principal = (User) authentication.getPrincipal();
        return "ss";
    }

}
