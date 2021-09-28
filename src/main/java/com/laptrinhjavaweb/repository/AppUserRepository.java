package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	 AppUser findByUserName(String userName);

}
