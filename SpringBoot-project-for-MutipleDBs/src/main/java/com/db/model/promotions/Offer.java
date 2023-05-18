package com.db.model.promotions;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JPA_Offer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;
    @NonNull
	private String offerName;
	@NonNull
	private String offerCode;
	@NonNull
	private Double discountPercentage;
	@NonNull
	private LocalDate expiryDate;

}
