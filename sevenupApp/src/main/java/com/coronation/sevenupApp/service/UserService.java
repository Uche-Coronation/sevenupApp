package com.coronation.sevenupApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.coronation.sevenupApp.model.PresentUser;
import com.coronation.sevenupApp.model.User;
import com.coronation.sevenupApp.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public Boolean doLogin(String userEmail, String userPassword) {
		User user = userRepo.findByUserEmail(userEmail);
		if(user == null) {
			return false;
		}else {
			if(user.getUserPassword().equals(userPassword)) {
				PresentUser.setUser(user);
				return true;
			}else {
				return false;
			}
		}
	}
	
	public Page<User> findAllUsers(Pageable pageable){
		return userRepo.findAll(pageable);
	}
	
	public User findUser(String id) {
		return userRepo.findById(Long.parseLong(id)).get();
	}

	public void removeUser(User user) {
		userRepo.delete(user);
	}
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
}
