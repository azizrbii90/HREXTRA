package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

}
