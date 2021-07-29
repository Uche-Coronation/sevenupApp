package com.coronation.sevenupApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coronation.sevenupApp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUserEmail(String userEmail);
	
}
