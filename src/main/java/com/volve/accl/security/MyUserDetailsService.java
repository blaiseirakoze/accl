package com.volve.accl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.Users;
import com.volve.accl.exception.HandlerNotFoundException;
import com.volve.accl.repository.UsersInterface;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    PasswordEncoder encoder;
	
	@Autowired
	private UsersInterface userInterface;
	
	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userInterface.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		if(user == null) {
			throw new HandlerNotFoundException("User Not Found with username: " + username);
		}
        return new MyUserDetails(user);
	}

}
