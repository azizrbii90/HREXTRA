package com.RHELP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RHELP.entities.Meeting;
import com.RHELP.repositories.MeetingRepo;

@Service
public class MeetingService {

	@Autowired
	private MeetingRepo meetingRepo;

	public List<Meeting> getAllMeetings() {
		
		return meetingRepo.findAll();
	}

	public Optional<Meeting> findMeetingById(Long id) {
		
		return meetingRepo.findById(id);
	}

	public Meeting saveMeeting(Meeting meeting) {
		
		return meetingRepo.save(meeting);
	}

	public Meeting updateMeeting(Meeting meeting) {
		
		return meetingRepo.save(meeting);
	}

	public void deleteMeeting(Meeting meeting) {
		
		if (meeting != null)
			meetingRepo.delete(meeting);
	}
}
