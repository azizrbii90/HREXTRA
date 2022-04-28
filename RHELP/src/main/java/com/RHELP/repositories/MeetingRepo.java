package com.RHELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Meeting;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, Long> {

}
