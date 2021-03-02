package by.it.petrov.jd02_04;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicTaskTest {

    private Parser parser;

    @Before
    public void createParser() {
        parser = new Parser();
    }

    @Test
    public void testA1() {
        String string = "A=2+5.3";
        String expected= "7.3";
        String actual = parser.calc(string).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testA2() {
        String variableDefinition = "A=7.3";
        parser.calc(variableDefinition);
        String string = "B=A*3.5";
        String expected= "25.55";
        String actual = parser.calc(string).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testA3() {
        String variableDefinition = "B=25.55";
        parser.calc(variableDefinition);
        String string = "B1=B+0.11*-5";
        String expected= "25.0";
        String actual = parser.calc(string).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testA4() {
        String variableDefinition = "A=7.3";
        parser.calc(variableDefinition);
        String string = "B2=A/2-1";
        String expected= "2.65";
        String actual = parser.calc(string).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testScalarSubScalar() {
        Var scalar1 = Var.createVar("7");
        Var scalar2 = Var.createVar("5");
        double expected = 2;
        double actual = Double.parseDouble(scalar1.sub(scalar2).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarAddScalar() {
        Var scalar1 = Var.createVar("7");
        Var scalar2 = Var.createVar("5");
        double expected = 12;
        double actual = Double.parseDouble(scalar1.add(scalar2).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarDivScalar() {
        Var var = Var.createVar("5");
        Var rav = Var.createVar("5");
        double expected = 1.0;
        double actual = Double.parseDouble(var.div(rav).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarMulScalar(){
        Var var = Var.createVar("3");
        Var rav = Var.createVar("2");
        double expected = 6;
        double actual = Double.parseDouble(var.mul(rav).toString());
        assertEquals(expected, actual, 1e-10);
    }
}
