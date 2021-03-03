package com.np.tdd.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	public int Add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else
			return getSum(numbers);			
	}
	
	public int getSum(String numbers) {
		return Arrays.stream(numbers.split(",")).filter(n->!n.isEmpty()).mapToInt(Integer::parseInt).sum();
	}

}
