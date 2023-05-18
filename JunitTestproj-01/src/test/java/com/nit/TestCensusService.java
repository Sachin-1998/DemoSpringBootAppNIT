package com.nit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCensusService 
{
	/*
	 * @RepeatedTest(value=5,
	 * name="Execution of {displayName}::{currentRepetition}/{totalRepetitions}")
	 * 
	 * @DisplayName("Data Export Test") public void testtransferData() {
	 * CensusService service=new CensusService();
	 * System.out.println("TestCensusService.testtransferData()");
	 * Assertions.assertEquals("Data Transfered", service.transferData()); }
	 */
	/*
	 * @ParameterizedTest
	 * 
	 * @ValueSource(ints= {10,21,22,46,78,12,7})
	 * 
	 * @DisplayName("Check the Number is odd or not.")
	 * 
	 * @Disabled public void testcheckIsOdd(int number) { CensusService service=new
	 * CensusService(); System.out.println("TestCensusService.testcheckIsOdd()");
	 * assertTrue(service.checkIsOdd(number)
	 * ,"Actual Results are not Matching with Expected"); }
	 */
	/*
	 * @ParameterizedTest
	 * 
	 * @ValueSource(strings= {"Sachin","Sahil"})
	 * 
	 * @DisplayName("Check the say Hello Method.") public void testsayHello(String
	 * user) { CensusService service=new CensusService();
	 * System.out.println("TestCensusService.testsayHello()");
	 * assertEquals("Hello"+user, service.sayHello(user)); }
	 */
	
	  @ParameterizedTest
	  
	  @ValueSource(ints= {20,17,23,29,11})
	  
	  @DisplayName("Check the age") public void testCheck(int num) { CensusService
	  service=new CensusService();
	  System.out.println("TestCensusService.testCheck()");
	  assertTrue(service.check(num),"Not Eligible For Voting.."); }
	 
	// @ParameterizedTest
	//@ValueSource(strings= {"","",","})
	//@EmptySource
	//@NullSource
	/*
	 * @NullAndEmptySource
	 * 
	 * @DisplayName("Testing String is blank..") public void testIsEmpty(String
	 * data) { CensusService service=new CensusService();
	 * System.out.println("TestCensusService.testIsEmpty()");
	 * assertTrue(service.isEmpty(data)); }
	 */
    @Test
	public void testcheckTwoArrayLength()
	{
		CensusService service=new CensusService();
		int[] actual={1,2,3,4};
		int [] expected= {1,2,3,4};
		assertArrayEquals(expected, actual);
		
	}
	
	

}
