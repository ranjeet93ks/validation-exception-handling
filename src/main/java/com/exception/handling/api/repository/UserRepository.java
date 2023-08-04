package com.exception.handling.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exception.handling.api.entity.User;

public interface UserRepository  extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
