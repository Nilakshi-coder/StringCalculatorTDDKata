package com.np.tdd.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	
	private StringCalculator calculator = null;
	
	@Before
	public void init() {
		calculator = new StringCalculator();
		System.out.println(calculator.toString());
	}

	@Test
	public void emptyString_Returns0() {
		assertEquals(0, calculator.Add(""));
	}
	
	@Test
	public void singleNumber_ReturnsSameNumber() {
		assertEquals(1, calculator.Add("1"));
	}
	
	@Test
	public void twoNumbers_ReturnsSumOfTwoNumbers() {
		assertEquals(3, calculator.Add("1,2"));
	}

}
