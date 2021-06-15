package com.Practice.onlineShoppingProject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Practice.onlineShoppingProject.Entites.Login;
@Repository

public interface LoginRepository extends JpaRepository<Login, Integer>{
public	Login findByLoginUser(String name);

	

}
