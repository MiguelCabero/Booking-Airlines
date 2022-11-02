package com.leonardo.angelit.jenkins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JenkinsCalcTest {

	@Test
	public void addTest() {
		final JenkinsCalculator calculator = new JenkinsCalculator();
		assertEquals(10, calculator.addNumbers(5, 5));

	}

	@Test
	public void subtractTest() {
		final JenkinsCalculator calculator = new JenkinsCalculator();
		assertEquals(5, calculator.subtractNumbers(10, 5));

	}

}
