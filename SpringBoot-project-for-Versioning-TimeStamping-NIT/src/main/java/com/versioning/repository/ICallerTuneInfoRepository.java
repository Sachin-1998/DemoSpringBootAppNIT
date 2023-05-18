package com.versioning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.versioning.entity.CallertuneInfo;

public interface ICallerTuneInfoRepository extends JpaRepository<CallertuneInfo, Integer> {

}
