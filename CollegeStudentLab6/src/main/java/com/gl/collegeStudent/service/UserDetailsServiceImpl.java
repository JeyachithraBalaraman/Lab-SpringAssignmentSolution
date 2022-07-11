package com.gl.collegeStudent.service;
import com.gl.collegeStudent.repository.UserRepository;
import com.gl.collegeStudent.entity.User;
import com.gl.collegeStudent.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.getUserByUsername(username);
	        
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	        System.out.println("username:"+user.getUsername()+"password"+user.getPassword());
	        return new MyUserDetails(user);
	    }

}
