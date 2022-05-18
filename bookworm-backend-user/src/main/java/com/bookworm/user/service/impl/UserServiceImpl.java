package com.bookworm.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.user.entity.UserEntity;
import com.bookworm.user.exception.UserNotFoundException;
import com.bookworm.user.model.User;
import com.bookworm.user.repo.UserRepository;
import com.bookworm.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public void addUser(User user) {
		userRepo.save(user.convertToEntity());
	}
	
	@Override
	public User signin(User user) throws UserNotFoundException {
		List<UserEntity> userEntities = userRepo.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
		if (userEntities.size() == 0) {
			throw new UserNotFoundException();
		}
		return userEntities.get(0).convertToModel();
	}

	@Override
	public List<User> fetchAllUser() {
		List<User> users = new ArrayList<>();
		for (UserEntity entity: userRepo.findAll()) {
			users.add(entity.convertToModel());
		}
		return users;
	}

	@Override
	public User viewUser(Integer userId) {
		return userRepo.findById(userId).get().convertToModel();
	}

}
