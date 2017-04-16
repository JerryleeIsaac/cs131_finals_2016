/* 
 * SOURCE: http://introcs.cs.princeton.edu/java/14array/Euler.java.html
 */

/******************************************************************************
 *  Compilation:  javac Euler.java
 *  Execution:    java Euler n
 *  
 *  Tests whether there are any five positive integers that satisfy
 *  a^5 + b^5 + c^5 + d^5 = e^5. In 1769 Euler conjectured that no such
 *  solutions exists, but his conjecture was disproved in 1966 using
 *  a computational approach like the one we take here.
 *
 *  The program reads in an integer command-line argument n and prints
 *  all solutions with a <= b <= c <= d <= e <= n. To speed things up by
 *  roughly a factor of 3 on my system, we precompute an array of
 *  fifth powers.
 *
 *  % java Euler 100
 *
 *  % java Euler 150
 *   27^5 + 84^5 + 110^5 + 133^5 = 144^5      // takes about 20 seconds
 *
 *
 ******************************************************************************/

public class Euler {

    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);

        // precompute i^5 for i = 0..n
        long[] five = new long[n+1];
        for (int i = 0; i <= n; i++)
            five[i] = (long) i * i * i * i * i;
        System.out.println("Done precomputing fifth powers");


        // now do exhaustive search
        for (int e = 1; e <= n; e++) {
            long e5 = five[e];

            // restrict search to a <= b <= c <= d <= e
            for (int a = 1; a <= n; a++) {
                long a5 = five[a];
                if (a5 + a5 + a5 + a5 > e5) break;

                for (int b = a; b <= n; b++) {
                    long b5 = five[b];
                    if (a5 + b5 + b5 + b5 > e5) break;

                    for (int c = b; c <= n; c++) {
                        long c5 = five[c];
                        if (a5 + b5 + c5 + c5 > e5) break;

                        for (int d = c; d <= n; d++) {
                            long d5 = five[d];
                            if (a5 + b5 + c5 + d5  > e5) break;
                            if (a5 + b5 + c5 + d5 == e5)
                            System.out.println(a + "^5 + " + b + "^5 + " + c + "^5 + " + d + "^5 = " + e + "^5"); 
                        }
                    }
                }
            }
        }
    }
}
