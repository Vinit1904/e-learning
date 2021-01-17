package com.cdac.elearning.config;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cdac.elearning.model.User;
 
public class CustomUserDetails implements UserDetails {
 
	@Autowired
    private User user;
     
	CustomUserDetails()
	{
		
	}
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getEmailId();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }
 
}
