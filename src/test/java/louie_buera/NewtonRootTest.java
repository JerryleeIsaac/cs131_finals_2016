package louie_buera;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

/**
 * https://octave.sourceforge.io/interval/package_doc/Root-Finding.html
 */

public class NewtonRootTest {

    private File file = new File("src/test/resources/test_files/louie_buera/NewtonRoot.in");
    private Scanner scanner;

    public NewtonRootTest() {
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("File input for NewtonRootTest not found", false);
        }
    }

    @Test
    public void testNewtonPolyExample() {
        String scanTestNo;
        do {
            scanTestNo = scanner.nextLine();
        } while(!scanTestNo.equals("Test 1"));

        double solEst = 1;
        double maxErr = Math.pow(10,-6);
        int iterMax = scanner.nextInt();

        scanner.nextLine();

        String func = scanner.nextLine();
        String funcDer = scanner.nextLine();

        double expected = scanner.nextDouble();
        double actual = NewtonRoot.NewtonRoot(func, funcDer, solEst, maxErr, iterMax);

        assertEquals("Root finder must pass given problem", expected, actual, maxErr);
    }
    
    @Test
    public void testNewtonLogExample() {
        String scanTestNo;
        do {
            scanTestNo = scanner.nextLine();
        } while(!scanTestNo.equals("Test 2"));

        double solEst = 1;
        double maxErr = Math.pow(10,-6);
        int iterMax = scanner.nextInt();

        scanner.nextLine();

        String func = scanner.nextLine();
        String funcDer = scanner.nextLine();

        double expected = scanner.nextDouble();
        double actual = NewtonRoot.NewtonRoot(func, funcDer, solEst, maxErr, iterMax);

        assertEquals("Root finder must pass given problem", expected, actual, maxErr);
    }
    
    @Test
    public void testNewtonTrigoExample() {
        String scanTestNo;
        do {
            scanTestNo = scanner.nextLine();
        } while(!scanTestNo.equals("Test 3"));

        double solEst = 1;
        double maxErr = Math.pow(10,-6);
        int iterMax = scanner.nextInt();

        scanner.nextLine();

        String func = scanner.nextLine();
        String funcDer = scanner.nextLine();

        double expected = scanner.nextDouble();
        double actual = NewtonRoot.NewtonRoot(func, funcDer, solEst, maxErr, iterMax);

        assertEquals("Root finder must pass given problem", expected, actual, maxErr);
    }
    
    @Test
    public void testNewtonGivenExample() {
        String scanTestNo;
        do {
            scanTestNo = scanner.nextLine();
        } while(!scanTestNo.equals("Test 4"));

        double solEst = 1;
        double maxErr = Math.pow(10,-9);
        int iterMax = scanner.nextInt();

        scanner.nextLine();

        String func = scanner.nextLine();
        String funcDer = scanner.nextLine();

        double expected = scanner.nextDouble();
        double actual = NewtonRoot.NewtonRoot(func, funcDer, solEst, maxErr, iterMax);

        assertEquals("Root finder must pass given problem", expected, actual, maxErr);
    }
}