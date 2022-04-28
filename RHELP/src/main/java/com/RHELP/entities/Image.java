package com.RHELP.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idImage;
	
	private  String name;
	private String type;
	
	@Lob
	private byte[] pic;

	public Image(String name, String type, byte[] pic) {
		super();
		this.name = name;
		this.type = type;
		this.pic = pic;
	}
	
	
	
	
	
}
