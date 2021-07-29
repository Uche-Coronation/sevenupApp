package com.coronation.sevenupApp.model;

import org.springframework.stereotype.Component;

@Component
public class PresentUser {

	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		PresentUser.user = user;
	}
	
}
