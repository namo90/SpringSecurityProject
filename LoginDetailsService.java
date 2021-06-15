package com.Practice.onlineShoppingProject.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Practice.onlineShoppingProject.Entites.Login;
import com.Practice.onlineShoppingProject.Repo.LoginRepository;
@Service
public class LoginDetailsService implements UserDetailsService {

	@Autowired
	LoginRepository loginRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//we can write repositry for fathcing data from database
		
		
	Login getuserDetails=	getUserDetails(username);
	
		if(username.equals(getuserDetails.getLoginUser())) {
	//	return (UserDetails) new Login("namo","namo123",new ArrayList<>());	
			return new org.springframework.security.core.userdetails.User(getuserDetails.getLoginUser(),getuserDetails.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("user not found");
			
		}
	}
	
	public Login getUserDetails(String username )
	{
			Login returnLoginValues = null;
		Optional<String> usernameOptional = Optional.of(username);
		if (usernameOptional.isPresent()) {
			Login loginDetails = loginRepository.findByLoginUser(username);
			returnLoginValues = loginDetails;
			return returnLoginValues;
		} else {
			return returnLoginValues;
		}
		
	}

}
