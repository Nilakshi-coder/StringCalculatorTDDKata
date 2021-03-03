package com.np.tdd.calculator;

import java.util.Arrays;
import java.util.stream.Collectors;
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
	
	public int[] getNumbersExcludingDelimiters(String numbers, String delimitertype) {
		return Arrays.stream(numbers.split(delimitertype))
				.filter(n->!n.trim().isEmpty())
				.mapToInt(Integer::parseInt)
				.toArray();
	}
	
	public int sum(int[] numbers) {
		checkForNegativeNumbers(numbers);
		return Arrays.stream(numbers).filter(n->n<=1000).sum();
	}

	public void checkForNegativeNumbers(int[] numbers) {
		String negativeNumbers = Arrays.stream(numbers)
				.filter(n->n<0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if(!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("Negatives are not allowed: "+negativeNumbers);
		}
	}
	
	public int getSum(String numbers) {
		if(numbers.startsWith(customDelimiterIdentifier)) {
			String[] parts = numbers.split(newLineChar,2);
			getCustomDelimiter(parts[0]);
			
			int[] noArray = getNumbersExcludingDelimiters(parts[1],customDelimiter);
			return sum(noArray);
		}else
			return sum(getNumbersExcludingDelimiters(numbers,defaultDelimiter));
	}
	
	public void getCustomDelimiter(String delPattern) {
		customDelimiter = delPattern.replace(customDelimiterIdentifier,"");
	}

}
