package com.nit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Testing with BankLoanService Class")
@TestMethodOrder(value = OrderAnnotation.class)
//@TestMethodOrder(value=MethodName.class)
//@TestMethodOrder(value = org.junit.jupiter.api.MethodOrderer.DisplayName.class)

class JunitTestproj01ApplicationTests {
	private static BankLoanService service;

	// berfore all specify the object of BankLoanService is exeute once.

	@BeforeAll
	public static void setUpOnce() {
		System.out.println("JunitTestproj01ApplicationTests.setUpOnce()");
		System.out.println("Set Up Once");
		service = new BankLoanService();
	}

	// for each test cases bankLoanService object is created seperately

	/*
	 * @Disabled public void setUp() {
	 * System.out.println("JunitTestproj01ApplicationTests.setUp()"); service = new
	 * BankLoanService(); }
	 */

	@Test
	@DisplayName("Testing with Small Numbers")
	@Order(1)
	@Tag("uat")
	@Tag("dev")
	public void testcalSimpleInterestSmallNumber(TestInfo info) {
		System.out.println("JunitTestproj01ApplicationTests.testcalSimpleInterestSmallNumber()");
		System.out.println(info.getTags() + " " + info.getDisplayName() + " " + info.getTestClass().get().getName()
				+ " " + info.getTestMethod().get().getName());
		float actual = service.calSimpleInterest(100000, 2, 12);
		float expected = 24000.0f;
		assertEquals(expected, actual, "May be actual results are not matching..");
	}

	@Test
	@DisplayName("Testing With Big Numbers")
	@Order(3)
	@Tag("dev")
	public void testcalSimpleInterestBigNumber() {
		System.out.println("JunitTestproj01ApplicationTests.testcalSimpleInterestBigNumber()");
		float actual = service.calSimpleInterest(10000000, 2, 12);
		float expected = 2400000.12678f;
		assertEquals(expected, actual, 0.6, "May be actual results are not matching..");
		// here 0.6 is the delta where we can specify that "0.6" difference is
		// niglisible
	}

	@Test
	@DisplayName("Testing With Invalid Inputs")
	@Order(-10)
	@Tag("uat")
	public void testcalSimpleInterestWithInvalidInput() {
		System.out.println("JunitTestproj01ApplicationTests.testcalSimpleInterestWithInvalidInput()");
		assertThrows(IllegalArgumentException.class, () -> {
			service.calSimpleInterest(0, 0, 0);

		}, "May be actual results are not matching..");
	}

	@Test
	@Disabled
	@DisplayName("Testing With Timer")
	@Order(11)
	@Tag("dev")
	public void testcalSimpleInterestWithTimer() {
		System.out.println("JunitTestproj01ApplicationTests.testcalSimpleInterestWithTimer()");
		assertTimeout(Duration.ofMillis(20000), () -> {
			service.calSimpleInterest(10000000, 2, 12);
		}, "Time is not matching ");

	}

	@Test

	@DisplayName("Testing for No Exception")
	@Order(2)
	@Tag("uat")
	public void testcalSimpleInterestForNoException() {

		System.out.println("JunitTestproj01ApplicationTests.testcalSimpleInterestForNoException()");
		assertDoesNotThrow(() -> {
			service.calSimpleInterest(100000, 2, 12);
		});

	}

	@AfterEach

	public void clear() {
		System.out.println("JunitTestproj01ApplicationTests.clear()");
		service = null;
	}

	@AfterAll
	public static void clearOnce() {
		System.out.println("JunitTestproj01ApplicationTests.clearOnce()");
		service = null;
	}
}
