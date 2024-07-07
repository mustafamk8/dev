package com.devanshu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devanshu.entity.Address;
import com.devanshu.entity.User;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
