package com.RHELP.entities;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
	
	@Id
	@GeneratedValue
	private long id ;
	
	private String title; 
	private String description;
	private LocalTime time;
	private boolean completed=false;
	private Date createdAt;
	
}

