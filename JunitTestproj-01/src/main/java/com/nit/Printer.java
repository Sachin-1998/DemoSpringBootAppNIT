package com.nit;

public class Printer 
{
	//make Printer class as singleton class
	private static Printer INSTANCE=new Printer();
	
	private Printer()
	{
		
	}
	public static Printer getInstance()
	{
		return INSTANCE;
	}

}
