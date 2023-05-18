package com.mapping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mapping.entities.Company;

public interface ICompanyRepo extends JpaRepository<Company, Integer> {

	//@Query("SELECT C.cId,C.cName,C.cAddress,C.cType,E.eId,E.eName,E.ePhoneNumber,E.eType FROM Company C inner join C.list E")
	//@Query("SELECT C.cId,C.cName,C.cAddress,C.cType,E.eId,E.eName,E.ePhoneNumber,E.eType FROM Company C left join C.list E")
	//@Query("SELECT C.cId,C.cName,C.cAddress,C.cType,E.eId,E.eName,E.ePhoneNumber,E.eType FROM Company C right join C.list E")
	//@Query("SELECT C.cId,C.cName,C.cAddress,C.cType,E.eId,E.eName,E.ePhoneNumber,E.eType FROM Company C FULL OUTER JOIN C.list E")

	public List<Object[] > fetchDataUsingJoins();
}
