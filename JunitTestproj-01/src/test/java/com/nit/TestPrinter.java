package com.nit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPrinter {
	@Test
	@DisplayName("Testing Singleton Class")
	public void testIsSingleTon() {
		System.out.println("TestPrinter.testIsSingleTon()");
		Printer p1 = Printer.getInstance();
		Printer p2 = Printer.getInstance();
		/*
		 * assertNotNull(p2); assertNotNull(p2);
		 */
		if (p1 == null || p2 == null)
			Assertions.fail("p1,p2,Not Pointing to same object..");
		//same checks the ref variables pointing to same object
		assertSame(p1, p2);
	}
}
