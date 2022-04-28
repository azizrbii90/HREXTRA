package com.RHELP.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.ERole;
import com.RHELP.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository <Role, Integer> {

	Optional <Role> findByName (ERole name);
}
