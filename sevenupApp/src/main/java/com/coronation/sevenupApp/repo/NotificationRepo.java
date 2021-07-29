package com.coronation.sevenupApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coronation.sevenupApp.model.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, String>{
	
}
