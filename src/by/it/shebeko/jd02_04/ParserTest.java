package by.it.shebeko.jd02_04;


import org.junit.Test;
import static org.junit.Assert.*;

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
}

