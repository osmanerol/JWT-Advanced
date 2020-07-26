package com.example.demojwt.DataAccess;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demojwt.Entity.Manager;

@Repository
public class ManagerDal implements IManagerDal {

	private EntityManager entityManager;
	
	@Autowired
	public ManagerDal(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public void addManager(Manager manager) {
		Session session=entityManager.unwrap(Session.class);
		session.save(manager);
	}

	@Override
	@Transactional
	public Manager findByUsername(String username) {
		Session session=entityManager.unwrap(Session.class);
		Manager manager=(Manager) session.createQuery("from Manager m where m.username=:username",Manager.class).setParameter("username", username).uniqueResult();
		return manager;
	}

}
