package by.it.shebeko.jd02_04;


import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {
    Parser parser = new Parser();

    @Test
    public void checkScalar1() throws CalcException {
        Var res = parser.calc("A=2+9");
        double actual = Double.parseDouble(res.toString());
        double expected = 11.0;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void checkScalar2() throws CalcException {
        Var res = parser.calc("4*8");
        double actual = Double.parseDouble(res.toString());
        double expected = 32.0;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void checkScalar3() throws CalcException {
        Var res = parser.calc("C=4*8+2+5*-2");
        double actual = Double.parseDouble(res.toString());
        double expected = 24;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void checkScalar4() throws CalcException {
        Var res = parser.calc("D =4*8+2+5*-2+18/-9 ");
        double actual = Double.parseDouble(res.toString());
        double expected = 22;
        assertEquals(expected, actual, 1e-10);
    }
}

