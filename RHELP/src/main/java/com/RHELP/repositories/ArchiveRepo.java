package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Archive;

@Repository
public interface ArchiveRepo extends JpaRepository<Archive, Long> {

}
