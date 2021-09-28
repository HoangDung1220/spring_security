package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.AppUser;
import com.laptrinhjavaweb.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	 List<UserRole> findByAppUser(AppUser  appUser);
}
