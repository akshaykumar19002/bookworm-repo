package com.bookworm.user.service;

import com.bookworm.user.exception.UserNotFoundException;
import com.bookworm.user.model.User;

import java.util.List;

public interface UserService {

	void addUser(User user);

	User signin(User user) throws UserNotFoundException;

	List fetchAllUser();

	User viewUser(Integer userId);

}
