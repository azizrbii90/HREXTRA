package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.RestController;

import com.RHELP.entities.Todo;

@Repository
@RestController
public interface TodoRepo extends JpaRepository<Todo, Long> {

}
