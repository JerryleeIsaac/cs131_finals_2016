package com.prob4.product;

import static org.junit.Assert.*;

import org.junit.Test;

public class ODE1Test {

	@Test
	public void test() {
		double s = ODE1.f(1, 3000, 500);
		double answer = -1725.00;
		
		assertEquals(answer,s, 0.0001);
	}

}
