package by.it.lapushkin.calc.test;

import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.model.support.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {
    //Test Scalar Operation
    @Test
    public void testScalarAddScalar() throws CalcException {
        Var var = Var.createVar("2");
        Var rav = Var.createVar("5");
        double expected = 7;
        double actual = Double.parseDouble(var.add(rav).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarSubScalar() throws CalcException {
        Var var = Var.createVar("2");
        Var rav = Var.createVar("5");
        double expected = -3;
        double actual = Double.parseDouble(var.sub(rav).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarDivScalar() throws CalcException {
        Var var = Var.createVar("2");
        Var rav = Var.createVar("5");
        double expected = 0.4;
        double actual = Double.parseDouble(var.div(rav).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarMulScalar() throws CalcException {
        Var var = Var.createVar("2");
        Var rav = Var.createVar("5");
        double expected = 10;
        double actual = Double.parseDouble(var.mul(rav).toString());
        assertEquals(expected, actual, 1e-10);
    }

    // Test Vector Operation
    @Test
    public void testVectorAddScalar() throws CalcException {
        Var var = Var.createVar("{2,3,5}");
        Var rav = Var.createVar("5");
        String expected = "{7.0,8.0,10.0}";
        String actual = var.add(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorAddVector() throws CalcException {
        Var var = Var.createVar("{2,3,5}");
        Var rav = Var.createVar("{4,1,6}");
        String expected = "{6.0,4.0,11.0}";
        String actual = var.add(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorSubScalar() throws CalcException {
        Var var = Var.createVar("{2,3,5}");
        Var rav = Var.createVar("5");
        String expected = "{-3.0,-2.0,-0.0}";
        String actual = var.sub(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorSubVector() throws CalcException {
        Var var = Var.createVar("{2,3,5}");
        Var rav = Var.createVar("{4,1,6}");
        String expected = "{-2.0,2.0,-1.0}";
        String actual = var.sub(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorMulScalar() throws CalcException {
        Var var = Var.createVar("{4,3,7}");
        Var rav = Var.createVar("5");
        String expected = "{20.0,15.0,35.0}";
        String actual = var.mul(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorMulVector() throws CalcException {
        Var var = Var.createVar("{4,3,7}");
        Var rav = Var.createVar("{1,3,3}");
        double expected = 34;
        double actual = Double.parseDouble(var.mul(rav).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testVectorDivScalar() throws CalcException {
        Var var = Var.createVar("{4,6,8}");
        Var rav = Var.createVar("2");
        String expected = "{2.0,3.0,4.0}";
        String actual = var.div(rav).toString();
        assertEquals(expected, actual);
    }

    //Test Matrix Operation
    @Test
    public void testMatrixAddScalar() throws CalcException {
        Var var = Var.createVar("{{4,6,8},{3,1,5}}");
        Var rav = Var.createVar("2");
        String expected = "{{6.0,8.0,10.0},{5.0,3.0,7.0}}";
        String actual = var.add(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixAddMatrix() throws CalcException {
        Var var = Var.createVar("{{4,6,8},{3,1,5}}");
        Var rav = Var.createVar("{{3,5,7},{2,3,4}}");
        String expected = "{{7.0,11.0,15.0},{5.0,4.0,9.0}}";
        String actual = var.add(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixSubScalar() throws CalcException {
        Var var = Var.createVar("{{4,6,8},{3,1,5}}");
        Var rav = Var.createVar("2");
        String expected = "{{2.0,4.0,6.0},{1.0,-1.0,3.0}}";
        String actual = var.sub(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixSubMatrix() throws CalcException {
        Var var = Var.createVar("{{4,6,8},{3,1,5}}");
        Var rav = Var.createVar("{{3,5,7},{2,3,4}}");
        String expected = "{{1.0,1.0,1.0},{1.0,-2.0,1.0}}";
        String actual = var.sub(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixMulScalar() throws CalcException {
        Var var = Var.createVar("{{4,6,8},{3,1,5}}");
        Var rav = Var.createVar("2");
        String expected = "{{8.0,12.0,16.0},{6.0,2.0,10.0}}";
        String actual = var.mul(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixMulVector() throws CalcException {
        Var var = Var.createVar("{{1,2,3},{3,1,5},{2,1,1}}");
        Var rav = Var.createVar("{2,1,3}");
        String expected = "{13.0,22.0,8.0}";
        String actual = var.mul(rav).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixMulMatrix() throws CalcException {
        Var var = Var.createVar("{{5,2,3},{8,1,5},{2,1,1}}");
        Var rav = Var.createVar("{{2,2,3},{3,1,5},{2,3,1}}");
        String expected = "{{32.0,9.0,19.0},{33.0,12.0,19.0},{36.0,8.0,22.0}}";
        String actual = var.mul(rav).toString();
        assertEquals(expected, actual);
    }
}
