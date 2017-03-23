/** Contains the formula for the second ordinary differential equation
  */
package com.prob4.product;
public class ODE2{
	public static double f(double t, double x, double y){
		return ((1.1*y)-(0.0005*x*y));
	}
}