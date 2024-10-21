package com.bikash.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
