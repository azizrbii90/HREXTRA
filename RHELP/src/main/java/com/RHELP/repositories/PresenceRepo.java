package com.RHELP.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Presence;


@Repository
public interface PresenceRepo extends JpaRepository<Presence, Long> {

	@Query("select p from Presence p where p.user.idUser = :id")
	public List<Presence> findUserPresenceByUserId(@Param("id") Long id);
	
}
