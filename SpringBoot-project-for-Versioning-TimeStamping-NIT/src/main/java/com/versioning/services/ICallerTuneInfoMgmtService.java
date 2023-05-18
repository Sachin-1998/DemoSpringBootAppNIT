package com.versioning.services;

import com.versioning.entity.CallertuneInfo;

public interface ICallerTuneInfoMgmtService 
{
	public String saveCallerTuneInfo(CallertuneInfo info);
	public String updateCallerTuneInfoById(Integer id,String callerTuneName,String movieName);
	public String getCallerTuneInfoById(Integer id);

}
