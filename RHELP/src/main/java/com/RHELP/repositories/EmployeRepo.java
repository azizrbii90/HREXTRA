package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Employe;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Long> {

}
