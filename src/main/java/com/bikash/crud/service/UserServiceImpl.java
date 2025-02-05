package com.bikash.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.crud.entity.User;
import com.bikash.crud.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

}
