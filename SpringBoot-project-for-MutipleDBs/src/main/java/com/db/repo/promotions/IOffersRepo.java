package com.db.repo.promotions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.promotions.Offer;

public interface IOffersRepo extends JpaRepository<Offer,Integer>{

	

}
