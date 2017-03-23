package com.prob4.product;

import static org.junit.Assert.*;

import org.junit.Test;

public class ODE2Test {

	@Test
	public void checkFuncntionF() {
		double s = ODE2.f(1, 3000, 500);
		double answer = -200;
		
		assertEquals(answer,s, 0.0001);
	}

}
