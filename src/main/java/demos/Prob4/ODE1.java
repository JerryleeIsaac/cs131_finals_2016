/** Contains the formula for the first ordinary differential equation
  */
package com.prob4.product;
public class ODE1{
	public static double f(double t, double x, double y){
		return ((0.00025*x*y)-(.7*x));
	}
}