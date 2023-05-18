package com.versioning.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="CallerTune_Info")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class CallertuneInfo 
{
	@Id
	@SequenceGenerator(name="Seq1",sequenceName = "Tune_Id_Seq",initialValue = 500,allocationSize = 1)
	@GeneratedValue(generator = "Seq1",strategy = GenerationType.SEQUENCE)
	@Column(name="CallerTune_Id")
	private Integer ctId;
	@NonNull
	@Column(name="CallerTune_Name",length = 40)
	private String tuneName;
	@NonNull
	@Column(name="Movie_Name",length = 40)
	private String MovieName;
	@Column(name="Updated_Count")
	@Version
	private Integer count;
	@Column(name="CallerTune_Service_Opted_On")
	@CreationTimestamp
	private LocalDateTime callerTuneOptedOn;
	@Column(name="CallerTune_Lastely_Updated_On")
	@UpdateTimestamp
	private LocalDateTime lastelyUpdatedOn;

}
