package com.RHELP.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDoc;
	private String titreDoc;
	private String typeDoc;
	private StatusOfRequest statusOfRequest;
	private boolean archived;
	
	@ManyToOne
	@JoinColumn(name="idUser", referencedColumnName="idUser")
	@JsonBackReference
	private Employe employe;
	
}
