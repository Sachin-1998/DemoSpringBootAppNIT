package com.versioning.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versioning.entity.CallertuneInfo;
import com.versioning.repository.ICallerTuneInfoRepository;

@Service
public class CallerTuneServiceImpl implements ICallerTuneInfoMgmtService {

	@Autowired
	private ICallerTuneInfoRepository callerTuneRepo;
	@Override
	public String saveCallerTuneInfo(CallertuneInfo info) {
		int id=callerTuneRepo.save(info).getCtId();
		return "CallerTune Info saved with id::"+id;
	}

	@Override
	public String updateCallerTuneInfoById(Integer id, String callerTuneName, String movieName) {
		Optional<CallertuneInfo> opt=callerTuneRepo.findById(id);
		if(opt.isPresent())
		{
			CallertuneInfo info = opt.get();
			info.setTuneName(callerTuneName);
			info.setMovieName(movieName);
			CallertuneInfo tune = callerTuneRepo.save(info);
			return "Object is upadted for "+tune.getCount()+"times...lastely modified on::"+tune.getLastelyUpdatedOn()+
					"Created on ::"+tune.getCallerTuneOptedOn();
			
		}
		else {
		return "Caller Tune id is not found";
		}
	}

	@Override
	public String getCallerTuneInfoById(Integer id) {
		CallertuneInfo info = callerTuneRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
		return "the caller Tune info is :::"+info;
	}

}
