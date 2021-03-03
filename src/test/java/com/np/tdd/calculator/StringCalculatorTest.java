package com.np.tdd.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void emptyString_Returns0() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(0, calculator.Add(""));
	}

}
