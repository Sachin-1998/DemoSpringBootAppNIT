package com.it.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@javax.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class JobSeeker 
{
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	@Column(length = 40)
	private String name;
	
	@NonNull
	@Column(length=40)
	private String addres;
	
	@NonNull
	private Boolean immediateJoiner;

	@NonNull
	@Lob
	private byte[] photo;
	
	@NonNull
	private LocalDateTime jdob;
	
	@NonNull
	@Lob
	private char[] resume;
	
	/*/home/sachin/Downloads/id.png

/home/sachin/Documents/CV SACHIN/Sachin-Shinde-GS-Lab-Experiance-Document1.pdf

1997-05-27T10:15:30*/
	
}
