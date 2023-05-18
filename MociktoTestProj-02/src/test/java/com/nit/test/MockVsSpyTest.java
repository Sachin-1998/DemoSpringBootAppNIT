package com.nit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockVsSpyTest
{
	@Test
	public void testlist()
	{
		List<String> listmock=Mockito.mock(ArrayList.class);
		List<String> listspy=Mockito.spy(new ArrayList());//spy
		listmock.add("table");
		listspy.add("table");
		Mockito.when(listmock.size()).thenReturn(10);//stub on mock obj
		Mockito.when(listspy.size()).thenReturn(10);//stub on spy obj
		System.out.println(listmock.size()+" "+listspy.size());
		
	}
	
	

}
