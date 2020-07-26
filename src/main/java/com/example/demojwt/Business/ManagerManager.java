package com.example.demojwt.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demojwt.DataAccess.IManagerDal;
import com.example.demojwt.Entity.Manager;

import static java.util.Collections.emptyList;

@Service
public class ManagerManager implements IManagerManager, UserDetailsService {

	private IManagerDal managerDal;
	
	@Autowired
	public ManagerManager(IManagerDal managerDal) {
		this.managerDal=managerDal;
	}
	
	@Override
	public void addManager(Manager manager) {
		this.managerDal.addManager(manager);
	}

	@Override
	public Manager findByUsername(String username) {
		return this.managerDal.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = this.managerDal.findByUsername(username);
		/*
        if (manager == null) {
            throw new UsernameNotFoundException(username);
        }
        */
        return new User(manager.getUsername(), manager.getPassword(), emptyList());
	}

}
