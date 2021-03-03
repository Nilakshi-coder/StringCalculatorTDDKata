package com.np.tdd.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	private static final String newLineChar = "\n";
	private static final String defaultDelimiter = ",|\n";
	private static final String customDelimiterIdentifier = "//";
	private String customDelimiter = "";

	public int Add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else
			return getSum(numbers);			
	}
	
	public int sum(String numbers, String delimitertype) {
		return Arrays.stream(numbers.split(delimitertype)).filter(n->!n.trim().isEmpty()).mapToInt(Integer::parseInt).sum();
	}
	
	public int getSum(String numbers) {
		if(numbers.startsWith(customDelimiterIdentifier)) {
			String[] parts = numbers.split(newLineChar,2);
			getCustomDelimiter(parts[0]);
			return sum(parts[1],customDelimiter);
		}else
			return sum(numbers,defaultDelimiter);
	}
	
	public void getCustomDelimiter(String delPattern) {
		customDelimiter = delPattern.substring(2,3);
	}

}
