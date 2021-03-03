package by.it.shebeko.jd02_07;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {
    Parser parser = new Parser();


    @Test
    public void checkScalar1() throws CalcException {
        Var res = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(res.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void checkScalar2() throws CalcException {
        Var res = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(res.toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void checkScalar3() throws CalcException {
        Var res = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(res.toString());
        double expected = 25;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void checkScalar4() throws CalcException {
        Var res = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(res.toString());
        double expected = 2.65;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void checkWithBrackets() throws CalcException {
        Var varA =parser.calc("A=7.3");
        Var varB =parser.calc("B=25.55");
        Var varC = parser.calcWithBrackets("C=B+(A*2)");
        double actual = Double.parseDouble(varC.toString());
        double expected = 40.15;
        assertEquals("Error ", expected, actual, 1e-10);
    }


    @Test
    public void checkWithBrackets1() throws CalcException {
        Var varC =parser.calc("C=40.15");
        Var varD = parser.calcWithBrackets("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(varD.toString());
        double expected = 10;
        assertEquals("Error ", expected, actual, 1e-10);
    }


    @Test
    public void checkVectors() throws CalcException {
        Var varD =parser.calc("D=10");
        double[] expected = {10,15};
        Var vector = parser.calcWithBrackets("E={2,3}*(D/2)");
        double[] actual = ((Vector)vector).getValue();
        assertArrayEquals("Error ", expected, actual, 1e-10);
    }
}

