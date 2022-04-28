package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Candidat;

@Repository
public interface CandidatRepo extends JpaRepository<Candidat, Long> {

}
