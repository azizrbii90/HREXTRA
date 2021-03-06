package com.RHELP.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.services.EmailService;
import com.RHELP.entities.Candidat;
import com.RHELP.entities.Mail;
import com.RHELP.repositories.CandidatRepo;

@RestController
public class EmailController {

	@Autowired
	public EmailService emailService;
	
	@Autowired
	public CandidatRepo candidatRepo;
	
	@GetMapping("/sendConfirmMessage/{id}")
	public String sendConfirmaMessage(@PathVariable("id") Long id) {
		
		Optional<Candidat> candidat = candidatRepo.findById(id);
		Mail mail = new Mail();
		mail.setFrom("rbiiaziz900@gmail.com");
		mail.setTo(candidat.get().getEmail());
		mail.setSubject("Invitation to interview at HRDATABANK");
		mail.setContent("Dear "+candidat.get().getPrenom()+","+"\r\n" + 
				"\r\n" + 
				"Thank you for applying to Hrdatabank.\r\n" + 
				"\r\n" + 
				"Your application for the position stood out to us and we would like to invite you for an interview at our office.\r\n" + 
				"\r\n" + 
				"We would like to conduct your interview sometime the week after Eid Holidays. \r\n" + 
				"\r\n" + 
				"I will be sending you a calendar invitation once I receive the disponibility calendar of the managers.\r\n" + 
				"\r\n" + 
				"If you have any questions or need additional information, please don’t hesitate to contact me by telephone or email.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"best regards,");
		
		emailService.sendSimpleMessage(mail);
		return "message sent successffully";
	}
	
	@GetMapping("/sendDenyMessage/{id}")
	public String sendDenyMessage(@PathVariable("id") Long id) {
		
		Optional<Candidat> candidat = candidatRepo.findById(id);
		Mail mail = new Mail();
		mail.setFrom("rbiiaziz900@gmail.com");
		mail.setTo(candidat.get().getEmail());
		mail.setSubject("Reply for your application at HRDATABANK");
		mail.setContent("Dear "+candidat.get().getPrenom()+","+"\r\n" + 
				"\r\n" + 
				"Thank you for applying to Hrdatabank.\r\n" + 
				"\r\n" + 
				"Following the examination of your application, we regret to inform you that we cannot give a favorable result.\r\n" + 
				"\r\n" + 
				"We will of course keep your file and we will not fail to contact you if, however, an opportunity arises.\r\n" + 
				"\r\n" + 
				"We hope that your research will be completed quickly, and we ask you to accept the expression of our best regards.\r\n" + 
				"\r\n" + 
				"best regards,");
		emailService.sendSimpleMessage(mail);
		return "message sent successffully";
		
	}
	
}
