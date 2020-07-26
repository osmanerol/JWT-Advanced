package com.example.demojwt.Business;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demojwt.Entity.Manager;

public interface IManagerManager {
	void addManager(Manager manager);
	Manager findByUsername(String username);
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
