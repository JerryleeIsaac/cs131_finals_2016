/*
 * SOURCE: http://introcs.cs.princeton.edu/java/93integration/TrapezoidalRule.java.html
*/

/******************************************************************************
 *  Compilation:  javac TrapezoidalRule.java
 *  Execution:    java TrapezoidalRule a b
 *  
 *  Numerically integrate the function in the interval [a, b].
 *
 *  % java TrapezoidalRule -3 3
 *  0.9973002031388447                 // true answer = 0.9973002040...
 *
 *  Observation: this says that 99.7% of time a standard normal random
 *  variable is within 3 standard deviation of its mean.
 *
 *  %  java TrapezoidalRule 0 100000
 *  1.9949108930964732                 // true answer = 1/2
 *
 *  Caveat: this is not the best way to integrate the normal density
 *  function. See what happens if you make b very big.
 *
 ******************************************************************************/


public class TrapezoidalRule {

  /**********************************************************************
   * Standard normal distribution density function.
   * Replace with any sufficiently smooth function.
   **********************************************************************/
   static double f(double x) {
      return Math.exp(- x * x / 2) / Math.sqrt(2 * Math.PI);
   }

  /**********************************************************************
   * Integrate f from a to b using the trapezoidal rule.
   * Increase N for more precision.
   **********************************************************************/
   static double integrate(double a, double b, int N) {
      double h = (b - a) / N;              // step size
      double sum = 0.5 * (f(a) + f(b));    // area
      for (int i = 1; i < N; i++) {
         double x = a + h * i;
         sum = sum + f(x);
      }

      return sum * h;
   }



   // sample client program
   public static void main(String[] args) { 
      double a = Double.parseDouble(args[0]);
      double b = Double.parseDouble(args[1]);
      StdOut.println(integrate(a, b, 1000));
   }

}
