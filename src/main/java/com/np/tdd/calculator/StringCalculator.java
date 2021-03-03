package com.np.tdd.calculator;

public class StringCalculator {
	
	public int Add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else
			if(numbers.contains(",")) {
				return Integer.parseInt(numbers.split(",")[0]) + Integer.parseInt(numbers.split(",")[1]);
			}
			return Integer.parseInt(numbers);
	}

}
