package com.example.demo.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;
import com.example.demo.model.Roles;

//Role repository

@Repository(value = "RoleRepository")
public interface RoleDao extends JpaRepository<Role, Integer> {
	Optional<Role> findByRoleName(Roles role);
}