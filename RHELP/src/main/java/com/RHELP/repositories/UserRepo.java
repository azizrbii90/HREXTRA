package com.RHELP.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.User;

@Repository
public interface UserRepo extends JpaRepository <User, Long> {

	Optional <User> findByUsername (String username);
	Boolean existsByUsername (String username);
	Boolean existsByEmail (String email);
	
	@Query("select u from User u where u.archived=1")
	List <User> getEmployees ();
	
	@Query("select u from User u where u.archived=2")
	List <User> getArchivedEmployees();
	
	Optional<User> findByEmail(String email);
	
}
