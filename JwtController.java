package com.Practice.onlineShoppingProject.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Practice.onlineShoppingProject.Entites.JwtTokenResponse;
import com.Practice.onlineShoppingProject.Entites.Login;
import com.Practice.onlineShoppingProject.jwt.helper.JwtUtil;
import com.Practice.onlineShoppingProject.jwt.service.LoginDetailsService;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class JwtController {
	@Autowired
	private LoginDetailsService loginDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value="/token",method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody Login login) throws Exception
	{
		System.out.println("getting username & pwd here "+" "+login);
		//return null;
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getLoginUser(), login.getPassword()));
		}catch (UsernameNotFoundException | BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
UserDetails userdetails	=	this.loginDetailsService.loadUserByUsername(login.getLoginUser());
		String token=this.jwtUtil.generateToken(userdetails);

return ResponseEntity.ok(new JwtTokenResponse(token));
	}
}
