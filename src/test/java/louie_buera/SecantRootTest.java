package louie_buera;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * https://en.wikipedia.org/wiki/Secant_method#A_computational_example
 */
public class SecantRootTest {

    @Test
    public void testSecantPolyExample() {
        File file = new File("src/test/resources/test_files/louie_buera/SecantRoot.in");
        Scanner scanner;

        try {
            scanner = new Scanner(file);

            double maxErr = Math.pow(10,-4);
            int iterMax = scanner.nextInt();
            scanner.nextLine();
            String func = scanner.nextLine();
            double Xa = scanner.nextDouble();
            double Xb = scanner.nextDouble();

            double expected = scanner.nextDouble();
            double actual = SecantRoot.SecantRoot(func, Xa, Xb, maxErr, iterMax);

            assertEquals("Root finder must pass given problem", expected, actual, maxErr);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("File input for SecantRootTest not found", false);
        }
    }

}
