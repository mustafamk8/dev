package com.devanshu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devanshu.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
