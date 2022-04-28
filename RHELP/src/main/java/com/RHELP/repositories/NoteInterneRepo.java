package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.NoteInterne;

@Repository
public interface NoteInterneRepo extends JpaRepository<NoteInterne, Long> {

}
