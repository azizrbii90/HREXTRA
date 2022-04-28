package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Administrateur;

@Repository
public interface AdministrateurRepo extends JpaRepository <Administrateur, Long > {

}
