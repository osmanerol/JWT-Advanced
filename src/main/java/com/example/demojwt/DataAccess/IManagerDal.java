package com.example.demojwt.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojwt.Entity.Manager;

public interface IManagerDal {
	void addManager(Manager manager);
	Manager findByUsername(String username);
}
