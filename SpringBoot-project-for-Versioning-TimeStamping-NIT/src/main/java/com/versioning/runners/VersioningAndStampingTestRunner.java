package com.versioning.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.versioning.entity.CallertuneInfo;
import com.versioning.services.ICallerTuneInfoMgmtService;

@Component
public class VersioningAndStampingTestRunner implements CommandLineRunner
{

	@Autowired
	private ICallerTuneInfoMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			CallertuneInfo info=new CallertuneInfo("Teri zalak sharfi srivalli", "Pushpa");
			System.out.println(service.saveCallerTuneInfo(info));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		/*try {
			System.out.println(service.updateCallerTuneInfoById(500, "Calm down", "selena album song"));
			System.out.println(service.getCallerTuneInfoById(500));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		try {
			System.out.println(service.updateCallerTuneInfoById(501, "Tu aake dekhle", "King album song"));
			System.out.println(service.getCallerTuneInfoById(501));
		} catch (Exception e) {
			e.printStackTrace();
		}

}
}
