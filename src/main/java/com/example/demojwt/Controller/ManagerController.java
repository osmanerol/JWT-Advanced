package com.example.demojwt.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demojwt.Business.IManagerManager;
import com.example.demojwt.Entity.Manager;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/managers")
public class ManagerController {
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 private IManagerManager managerManager;
	 
	public ManagerController(BCryptPasswordEncoder bCryptPasswordEncoder, IManagerManager managerManager) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.managerManager = managerManager;
	}
	 
	@PostMapping("/signup")
    public void signUp(@RequestBody Manager manager) {
        manager.setPassword(bCryptPasswordEncoder.encode(manager.getPassword()));
        managerManager.addManager(manager);
    }
	
	 
}
