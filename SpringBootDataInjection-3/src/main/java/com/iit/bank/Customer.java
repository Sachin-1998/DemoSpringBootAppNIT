package com.iit.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("custominfo")
public class Customer 
{
	@Value("${custom.accountid}")
	private Integer cid;
	@Value("${custom.name}")
	private String cname;
	@Value("${custom.address}")
	private String caddress;
	@Value("${custom.accountNumber}")
	private Long caccountNumber;
	@Value("${custom.type}")
	private String caccountType;
	//data injection through spel
	@Value("#{bankinfo.loanAmount}")
	private String loanTakenByCustomer;
	//injecting system property
	@Value("${os.name}")
	private String osName;
	//injecting environment variables
	@Value("${Path}")
	private String pathdata;
	
	public Integer getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public Long getCaccountNumber() {
		return caccountNumber;
	}
	public String getCaccountType() {
		return caccountType;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public void setCaccountNumber(Long caccountNumber) {
		this.caccountNumber = caccountNumber;
	}
	public void setCaccountType(String caccountType) {
		this.caccountType = caccountType;
	}
	public String getOsName() {
		return osName;
	}
	public String getPathdata() {
		return pathdata;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public void setPathdata(String pathdata) {
		this.pathdata = pathdata;
	}
	public String getLoanTakenByCustomer() {
		return loanTakenByCustomer;
	}
	public void setLoanTakenByCustomer(String loanTakenByCustomer) {
		this.loanTakenByCustomer = loanTakenByCustomer;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddress=" + caddress + ", caccountNumber="
				+ caccountNumber + ", caccountType=" + caccountType + ", loanTakenByCustomer=" + loanTakenByCustomer
				+ ", osName=" + osName + ", pathdata=" + pathdata + "]";
	}
	
	
	

}
