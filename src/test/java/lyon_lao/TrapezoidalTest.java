package lyon_lao;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

public class TrapezoidalTest {
	
	static Scanner scan;
	static double expectedIntegral;
	Double [][] trapAnswers = TrapezoidalClass.Trapezoidal("x^2", 0d, 100d, 20);
	
	@Test
	public void testIntegral() {
		try {
			String dir = new File(".").getCanonicalPath();
			File in = new File(dir + "/src/test/resources/test_files/lyon_lao/Trapezoidal.in");
			scan = new Scanner(in);
			//Getting integral
			String line = scan.nextLine();
			expectedIntegral = Double.parseDouble(line);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		assertEquals(trapAnswers[0][0], expectedIntegral, 0.00000000001);
	}

}
