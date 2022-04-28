package com.RHELP.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Conge;

@Repository
public interface CongeRepo extends JpaRepository <Conge, Long> {

	@Query("select c from Conge c where c.statusOfRequest like 'waiting'")
	public List <Conge> getCongeByStatus();
	
	@Query("select count(duree) from Conge c where c.user.idUser = :id")
	public int countDuree(Long id);
	
}

