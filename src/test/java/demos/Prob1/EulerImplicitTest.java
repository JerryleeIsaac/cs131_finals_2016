package demos.Prob1;

import louie_buera.NewtonRoot;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by angeloarenas on 21/02/2017.
 */
public class EulerImplicitTest {

    @Test
    public void testGivenProblem() {
        File file = new File("src/test/resources/test_files/demos/Prob1/EulerImplicit.in");

        try {
            Scanner scanner = new Scanner(file);
            double firstNum = 0, lastNum = 0.5, stepSize = 0.002, eulerN;
            int i, newtonN;
            eulerN = (lastNum - firstNum)/stepSize; // number of iterations for euler
            newtonN = 250; // number of iterations for newton

            double[] n = new double[251];
            double[] t = new double[251];

            n[0] = 0;
            n[1] = 2000; t[1] = firstNum;

            for(i = 1; i < eulerN; i++) {
                t[i + 1] = t[i] + stepSize;

                Double fun_component1 = -(10 * 2000 * ( 1-Math.exp(-3*(t[i+1]))) * stepSize) - n[i];
                Double fun_component2 = 0.8 * stepSize;

                String fun = "x + x^(3/2) * " + fun_component2 + " + " + fun_component1;
                String funDer = "1 + x^(1/2) * (3/2) * " + fun_component2;

                n[i+1] = NewtonRoot.NewtonRoot(fun, funDer, n[i], 0.001, newtonN);
            }

            double[] expected = new double[251];

            expected[0]     = scanner.nextDouble();
            expected[1]     = scanner.nextDouble();
            expected[2]     = scanner.nextDouble();
            expected[3]     = scanner.nextDouble();
            expected[4]     = scanner.nextDouble();
            expected[5]     = scanner.nextDouble();
            expected[6]     = scanner.nextDouble();
            expected[7]     = scanner.nextDouble();
            expected[8]     = scanner.nextDouble();
            expected[9]     = scanner.nextDouble();
            expected[10]    = scanner.nextDouble();
            expected[11]    = scanner.nextDouble();
            expected[12]    = scanner.nextDouble();
            expected[13]    = scanner.nextDouble();
            expected[14]    = scanner.nextDouble();
            expected[15]    = scanner.nextDouble();
            expected[16]    = scanner.nextDouble();
            expected[17]    = scanner.nextDouble();
            expected[18]    = scanner.nextDouble();
            expected[19]    = scanner.nextDouble();
            expected[20]    = scanner.nextDouble();
            expected[21]    = scanner.nextDouble();
            expected[22]    = scanner.nextDouble();
            expected[23]    = scanner.nextDouble();
            expected[24]    = scanner.nextDouble();
            expected[25]    = scanner.nextDouble();
            expected[26]    = scanner.nextDouble();
            expected[27]    = scanner.nextDouble();
            expected[28]    = scanner.nextDouble();
            expected[29]    = scanner.nextDouble();
            expected[30]    = scanner.nextDouble();
            expected[31]    = scanner.nextDouble();
            expected[32]    = scanner.nextDouble();
            expected[33]    = scanner.nextDouble();
            expected[34]    = scanner.nextDouble();
            expected[35]    = scanner.nextDouble();
            expected[36]    = scanner.nextDouble();
            expected[37]    = scanner.nextDouble();
            expected[38]    = scanner.nextDouble();
            expected[39]    = scanner.nextDouble();
            expected[40]    = scanner.nextDouble();
            expected[41]    = scanner.nextDouble();
            expected[42]    = scanner.nextDouble();
            expected[43]    = scanner.nextDouble();
            expected[44]    = scanner.nextDouble();
            expected[45]    = scanner.nextDouble();
            expected[46]    = scanner.nextDouble();
            expected[47]    = scanner.nextDouble();
            expected[48]    = scanner.nextDouble();
            expected[49]    = scanner.nextDouble();
            expected[50]    = scanner.nextDouble();
            expected[51]    = scanner.nextDouble();
            expected[52]    = scanner.nextDouble();
            expected[53]    = scanner.nextDouble();
            expected[54]    = scanner.nextDouble();
            expected[55]    = scanner.nextDouble();
            expected[56]    = scanner.nextDouble();
            expected[57]    = scanner.nextDouble();
            expected[58]    = scanner.nextDouble();
            expected[59]    = scanner.nextDouble();
            expected[60]    = scanner.nextDouble();
            expected[61]    = scanner.nextDouble();
            expected[62]    = scanner.nextDouble();
            expected[63]    = scanner.nextDouble();
            expected[64]    = scanner.nextDouble();
            expected[65]    = scanner.nextDouble();
            expected[66]    = scanner.nextDouble();
            expected[67]    = scanner.nextDouble();
            expected[68]    = scanner.nextDouble();
            expected[69]    = scanner.nextDouble();
            expected[70]    = scanner.nextDouble();
            expected[71]    = scanner.nextDouble();
            expected[72]    = scanner.nextDouble();
            expected[73]    = scanner.nextDouble();
            expected[74]    = scanner.nextDouble();
            expected[75]    = scanner.nextDouble();
            expected[76]    = scanner.nextDouble();
            expected[77]    = scanner.nextDouble();
            expected[78]    = scanner.nextDouble();
            expected[79]    = scanner.nextDouble();
            expected[80]    = scanner.nextDouble();
            expected[81]    = scanner.nextDouble();
            expected[82]    = scanner.nextDouble();
            expected[83]    = scanner.nextDouble();
            expected[84]    = scanner.nextDouble();
            expected[85]    = scanner.nextDouble();
            expected[86]    = scanner.nextDouble();
            expected[87]    = scanner.nextDouble();
            expected[88]    = scanner.nextDouble();
            expected[89]    = scanner.nextDouble();
            expected[90]    = scanner.nextDouble();
            expected[91]    = scanner.nextDouble();
            expected[92]    = scanner.nextDouble();
            expected[93]    = scanner.nextDouble();
            expected[94]    = scanner.nextDouble();
            expected[95]    = scanner.nextDouble();
            expected[96]    = scanner.nextDouble();
            expected[97]    = scanner.nextDouble();
            expected[98]    = scanner.nextDouble();
            expected[99]    = scanner.nextDouble();
            expected[100] = scanner.nextDouble();
            expected[101] = scanner.nextDouble();
            expected[102] = scanner.nextDouble();
            expected[103] = scanner.nextDouble();
            expected[104] = scanner.nextDouble();
            expected[105] = scanner.nextDouble();
            expected[106] = scanner.nextDouble();
            expected[107] = scanner.nextDouble();
            expected[108] = scanner.nextDouble();
            expected[109] = scanner.nextDouble();
            expected[110] = scanner.nextDouble();
            expected[111] = scanner.nextDouble();
            expected[112] = scanner.nextDouble();
            expected[113] = scanner.nextDouble();
            expected[114] = scanner.nextDouble();
            expected[115] = scanner.nextDouble();
            expected[116] = scanner.nextDouble();
            expected[117] = scanner.nextDouble();
            expected[118] = scanner.nextDouble();
            expected[119] = scanner.nextDouble();
            expected[120] = scanner.nextDouble();
            expected[121] = scanner.nextDouble();
            expected[122] = scanner.nextDouble();
            expected[123] = scanner.nextDouble();
            expected[124] = scanner.nextDouble();
            expected[125] = scanner.nextDouble();
            expected[126] = scanner.nextDouble();
            expected[127] = scanner.nextDouble();
            expected[128] = scanner.nextDouble();
            expected[129] = scanner.nextDouble();
            expected[130] = scanner.nextDouble();
            expected[131] = scanner.nextDouble();
            expected[132] = scanner.nextDouble();
            expected[133] = scanner.nextDouble();
            expected[134] = scanner.nextDouble();
            expected[135] = scanner.nextDouble();
            expected[136] = scanner.nextDouble();
            expected[137] = scanner.nextDouble();
            expected[138] = scanner.nextDouble();
            expected[139] = scanner.nextDouble();
            expected[140] = scanner.nextDouble();
            expected[141] = scanner.nextDouble();
            expected[142] = scanner.nextDouble();
            expected[143] = scanner.nextDouble();
            expected[144] = scanner.nextDouble();
            expected[145] = scanner.nextDouble();
            expected[146] = scanner.nextDouble();
            expected[147] = scanner.nextDouble();
            expected[148] = scanner.nextDouble();
            expected[149] = scanner.nextDouble();
            expected[150] = scanner.nextDouble();
            expected[151] = scanner.nextDouble();
            expected[152] = scanner.nextDouble();
            expected[153] = scanner.nextDouble();
            expected[154] = scanner.nextDouble();
            expected[155] = scanner.nextDouble();
            expected[156] = scanner.nextDouble();
            expected[157] = scanner.nextDouble();
            expected[158] = scanner.nextDouble();
            expected[159] = scanner.nextDouble();
            expected[160] = scanner.nextDouble();
            expected[161] = scanner.nextDouble();
            expected[162] = scanner.nextDouble();
            expected[163] = scanner.nextDouble();
            expected[164] = scanner.nextDouble();
            expected[165] = scanner.nextDouble();
            expected[166] = scanner.nextDouble();
            expected[167] = scanner.nextDouble();
            expected[168] = scanner.nextDouble();
            expected[169] = scanner.nextDouble();
            expected[170] = scanner.nextDouble();
            expected[171] = scanner.nextDouble();
            expected[172] = scanner.nextDouble();
            expected[173] = scanner.nextDouble();
            expected[174] = scanner.nextDouble();
            expected[175] = scanner.nextDouble();
            expected[176] = scanner.nextDouble();
            expected[177] = scanner.nextDouble();
            expected[178] = scanner.nextDouble();
            expected[179] = scanner.nextDouble();
            expected[180] = scanner.nextDouble();
            expected[181] = scanner.nextDouble();
            expected[182] = scanner.nextDouble();
            expected[183] = scanner.nextDouble();
            expected[184] = scanner.nextDouble();
            expected[185] = scanner.nextDouble();
            expected[186] = scanner.nextDouble();
            expected[187] = scanner.nextDouble();
            expected[188] = scanner.nextDouble();
            expected[189] = scanner.nextDouble();
            expected[190] = scanner.nextDouble();
            expected[191] = scanner.nextDouble();
            expected[192] = scanner.nextDouble();
            expected[193] = scanner.nextDouble();
            expected[194] = scanner.nextDouble();
            expected[195] = scanner.nextDouble();
            expected[196] = scanner.nextDouble();
            expected[197] = scanner.nextDouble();
            expected[198] = scanner.nextDouble();
            expected[199] = scanner.nextDouble();
            expected[200] = scanner.nextDouble();
            expected[201] = scanner.nextDouble();
            expected[202] = scanner.nextDouble();
            expected[203] = scanner.nextDouble();
            expected[204] = scanner.nextDouble();
            expected[205] = scanner.nextDouble();
            expected[206] = scanner.nextDouble();
            expected[207] = scanner.nextDouble();
            expected[208] = scanner.nextDouble();
            expected[209] = scanner.nextDouble();
            expected[210] = scanner.nextDouble();
            expected[211] = scanner.nextDouble();
            expected[212] = scanner.nextDouble();
            expected[213] = scanner.nextDouble();
            expected[214] = scanner.nextDouble();
            expected[215] = scanner.nextDouble();
            expected[216] = scanner.nextDouble();
            expected[217] = scanner.nextDouble();
            expected[218] = scanner.nextDouble();
            expected[219] = scanner.nextDouble();
            expected[220] = scanner.nextDouble();
            expected[221] = scanner.nextDouble();
            expected[222] = scanner.nextDouble();
            expected[223] = scanner.nextDouble();
            expected[224] = scanner.nextDouble();
            expected[225] = scanner.nextDouble();
            expected[226] = scanner.nextDouble();
            expected[227] = scanner.nextDouble();
            expected[228] = scanner.nextDouble();
            expected[229] = scanner.nextDouble();
            expected[230] = scanner.nextDouble();
            expected[231] = scanner.nextDouble();
            expected[232] = scanner.nextDouble();
            expected[233] = scanner.nextDouble();
            expected[234] = scanner.nextDouble();
            expected[235] = scanner.nextDouble();
            expected[236] = scanner.nextDouble();
            expected[237] = scanner.nextDouble();
            expected[238] = scanner.nextDouble();
            expected[239] = scanner.nextDouble();
            expected[240] = scanner.nextDouble();
            expected[241] = scanner.nextDouble();
            expected[242] = scanner.nextDouble();
            expected[243] = scanner.nextDouble();
            expected[244] = scanner.nextDouble();
            expected[245] = scanner.nextDouble();
            expected[246] = scanner.nextDouble();
            expected[247] = scanner.nextDouble();
            expected[248] = scanner.nextDouble();
            expected[249] = scanner.nextDouble();
            expected[250] = scanner.nextDouble();

            assertArrayEquals("Must pass given problem", expected, n, 0.001);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("File input for EulerImplicitTest not found", false);
        }
    }
}