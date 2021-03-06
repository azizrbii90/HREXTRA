package com.RHELP.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeMeeting implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PKEmployeMeeting pkEmployeMeetin;
	
	@ManyToOne
	@JoinColumn(name="idMeeting", referencedColumnName="idMeeting", insertable=false, updatable=false)
	private Meeting meeting;
	
	@ManyToOne
	@JoinColumn(name="idUser", referencedColumnName="idUser", insertable=false, updatable=false)
	private Employe employe;
	
}
