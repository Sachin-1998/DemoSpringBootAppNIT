package com.nit;

public class CensusService {
	public String transferData() {
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Data Transfered";
	}

	public boolean checkIsOdd(int number) {

		if (number % 2 == 0)
			return false;
		else
			return true;
	}

	public String sayHello(String user) {
		return "Hello" + user;
	}

	public boolean check(int age) {
		if (age >= 18)
			return true;
		else
			return false;
	}

	public boolean isEmpty(String name) {
		return name.isBlank();
	}

	public String checkTwoArrayLength(int[] a, int[] b) {

		if (a.length == b.length)
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (a[i] == b[j])
						return "equal";
					else
						return "not equal";

				}

			}
		return "equal";

	}
}
