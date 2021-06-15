package com.Practice.onlineShoppingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Practice.onlineShoppingProject.Entites.Login;
import com.Practice.onlineShoppingProject.Repo.LoginRepository;

@RestController
public class UserLogin {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	Login login;
	@RequestMapping("/login1")
	public String checkAuthanication(String name,String password)
	{
	
		return "";
		
	}
	@RequestMapping("/welcome")
	public String welcome()
	{
		String text="this is privatepage";
		text+="this page is not allowed to unauthenticated users";
		return text;
	}
}
