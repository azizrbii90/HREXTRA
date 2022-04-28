package com.RHELP.repositories;

import com.RHELP.entities.AppelOffre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelOffreRepo extends JpaRepository<AppelOffre, Long> {

}
