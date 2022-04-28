package com.RHELP.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class PKCandidateAppelOffre implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCandidate;
	private Long idAppelOffre;
	
}
