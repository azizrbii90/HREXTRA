package com.RHELP.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Presence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPresence;
	
	private LocalDate day;
	private int nbrheures;

	@ManyToOne
	private User user;

}
