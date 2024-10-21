package com.bikash.crud.service;

import java.util.List;

import com.bikash.crud.entity.User;

public interface UserService {
	
	
	List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);

}
