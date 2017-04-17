package jerick_callado;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

public class ODE1Test {
	static Scanner scan;
	@Test
	public void test() {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			String dir = new File( "." ).getCanonicalPath();
			File in = new File(dir + "/src/test/resources/test_files/jerick_callado/ODE1.in");
			scan = new Scanner(in);
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			double z = scan.nextDouble();
			double a = scan.nextDouble();
			double s = ODE1.f(x,y,z);
			assertEquals(a,s, 0.0001);
			
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}

}
