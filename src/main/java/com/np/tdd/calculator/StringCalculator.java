package com.np.tdd.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	private static final String defaultDelimiter = ",|\n";

	public int Add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else
			return getSum(numbers);			
	}
	
	public int getSum(String numbers) {
		return Arrays.stream(numbers.split(defaultDelimiter)).filter(n->!n.isEmpty()).mapToInt(Integer::parseInt).sum();
	}

}
