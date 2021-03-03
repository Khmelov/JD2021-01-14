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
        System.out.println();
        System.out.println("TestA1");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testA2() {
        String variableDefinition = "A=7.3";
        parser.calc(variableDefinition);
        String string = "B=A*3.5";
        String expected= "25.55";
        String actual = parser.calc(string).toString();
        System.out.println();
        System.out.println("TestA2");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testA3() {
        String variableDefinition = "B=25.55";
        parser.calc(variableDefinition);
        String string = "B1=B+0.11*-5";
        String expected= "25.0";
        String actual = parser.calc(string).toString();
        System.out.println();
        System.out.println("TestA3");
        System.out.println("Выражение: " + string);
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testA4() {
        String variableDefinition = "A=7.3";
        parser.calc(variableDefinition);
        String string = "B2=A/2-1";
        String expected= "2.65";
        String actual = parser.calc(string).toString();
        System.out.println();
        System.out.println("TestA4");
        System.out.println("Выражение: " + string);
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testB5() {
        String variableDefinition = "A=7.3";
        parser.calc(variableDefinition);
        String variableDefinition1 = "B=25.55";
        parser.calc(variableDefinition1);
        String string = "C=B+(A*2)";
        String expected= "40.15";
        String actual = parser.calc(string).toString();
        System.out.println();
        System.out.println("TestB5");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testB6() {
        String variableDefinition = "C=40.15";
        parser.calc(variableDefinition);
        String string = "D=((C-0.15)-20)/(7-5)";
        String expected= "10.0";
        String actual = parser.calc(string).toString();
        System.out.println();
        System.out.println("TestB6");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testB7() {
        String variableDefinition = "D=10.0";
        parser.calc(variableDefinition);
        String string = "E={2,3}*(D/2)";
        String expected= "{10.0, 15.0}";
        String actual = parser.calc(string).toString();
        System.out.println();
        System.out.println("TestB7");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testC8() {
        String variableDefinition = "X={30.0, 17.0}";
        parser.calc(variableDefinition);
        String string = "V={{5,1},{7,3}}*X";
        String expected= "{167.0, 261.0}";
        String actual = parser.calc(string).toString();
        System.out.println();
        System.out.println("TestC8");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testScalarSubScalar() {
        Var scalar1 = Var.createVar("7");
        Var scalar2 = Var.createVar("5");
        double expected = 2;
        double actual = Double.parseDouble(scalar1.sub(scalar2).toString());
        System.out.println();
        System.out.println("testScalarSubScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarAddScalar() {
        Var scalar1 = Var.createVar("7");
        Var scalar2 = Var.createVar("5");
        double expected = 12;
        double actual = Double.parseDouble(scalar1.add(scalar2).toString());
        System.out.println();
        System.out.println("testScalarAddScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarDivScalar() {
        Var var = Var.createVar("5");
        Var var2 = Var.createVar("5");
        double expected = 1.0;
        double actual = Double.parseDouble(var.div(var2).toString());
        System.out.println();
        System.out.println("testScalarDivScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testScalarMulScalar(){
        Var var = Var.createVar("3");
        Var var2 = Var.createVar("2");
        double expected = 6;
        double actual = Double.parseDouble(var.mul(var2).toString());
        System.out.println();
        System.out.println("testScalarMulScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testVectorAddScalar(){
        Var var = Var.createVar("{1,3,7}");
        Var var2 = Var.createVar("5");
        String expected = "{6.0, 8.0, 12.0}";
        String actual = var.add(var2).toString();
        System.out.println();
        System.out.println("testScalarMulScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorAddVector(){
        Var var = Var.createVar("{7,5,1}");
        Var var2 = Var.createVar("{2,3,2}");
        String expected = "{9.0, 8.0, 3.0}";
        String actual = var.add(var2).toString();
        System.out.println();
        System.out.println("testVectorAddVector");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorSubScalar(){
        Var var = Var.createVar("{2,3,5}");
        Var var2 = Var.createVar("7");
        String expected = "{-5.0, -4.0, -2.0}";
        String actual = var.sub(var2).toString();
        System.out.println();
        System.out.println("testVectorSubScala");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorSubVector(){
        Var var = Var.createVar("{0,1,2}");
        Var var2 = Var.createVar("{3,2,1}");
        String expected = "{-3.0, -1.0, 1.0}";
        String actual = var.sub(var2).toString();
        System.out.println();
        System.out.println("testVectorSubVector");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorMulScalar(){
        Var var = Var.createVar("{5,5,5}");
        Var var2 = Var.createVar("5");
        String expected = "{25.0, 25.0, 25.0}";
        String actual = var.mul(var2).toString();
        System.out.println();
        System.out.println("testVectorMulScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testVectorMulVector(){
        Var var = Var.createVar("{1,7,7}");
        Var var2 = Var.createVar("{6,5,4}");
        double expected = 69;
        double actual = Double.parseDouble(var.mul(var2).toString());
        System.out.println();
        System.out.println("testVectorMulVector");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testVectorDivScalar(){
        Var var = Var.createVar("{1,1,1}");
        Var var2 = Var.createVar("2");
        String expected = "{0.5, 0.5, 0.5}";
        String actual = var.div(var2).toString();
        System.out.println();
        System.out.println("testVectorDivScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    //Test Matrix Operation
    @Test
    public void testMatrixAddScalar(){
        Var var = Var.createVar("{{1,2,3},{4,5,6}}");
        Var var2 = Var.createVar("7");
        String expected = "{{8.0, 9.0, 10.0}, {11.0, 12.0, 13.0}}";
        String actual = var.add(var2).toString();
        System.out.println();
        System.out.println("testMatrixAddScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixAddMatrix(){
        Var var = Var.createVar("{{1,2,3},{4,5,6}}");
        Var var2 = Var.createVar("{{1,2,3},{4,5,6}}");
        String expected = "{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}}";
        String actual = var.add(var2).toString();
        System.out.println();
        System.out.println("testMatrixAddMatrix");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixSubScalar(){
        Var var = Var.createVar("{{1,2,3},{4,5,6}}");
        Var var2 = Var.createVar("1");
        String expected = "{{0.0, 1.0, 2.0}, {3.0, 4.0, 5.0}}";
        String actual = var.sub(var2).toString();
        System.out.println();
        System.out.println("testMatrixSubScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixSubMatrix(){
        Var var = Var.createVar("{{1,2,3},{4,5,6}}");
        Var var2 = Var.createVar("{{7,7,7},{1,1,2}}");
        String expected = "{{-6.0, -5.0, -4.0}, {3.0, 4.0, 4.0}}";
        String actual = var.sub(var2).toString();
        System.out.println();
        System.out.println("testMatrixSubMatrix");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixMulScalar(){
        Var var = Var.createVar("{{1,2,3},{4,5,6}}");
        Var var2 = Var.createVar("5");
        String expected = "{{5.0, 10.0, 15.0}, {20.0, 25.0, 30.0}}";
        String actual = var.mul(var2).toString();
        System.out.println();
        System.out.println("testMatrixMulScalar");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixMulVector(){
        Var var = Var.createVar("{{7,6,5},{1,2,3},{42,10,11}}");
        Var var2 = Var.createVar("{5,5,5}");
        String expected = "{90.0, 30.0, 315.0}";
        String actual = var.mul(var2).toString();
        System.out.println();
        System.out.println("testMatrixMulVector");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testMatrixMulMatrix(){
        Var var = Var.createVar("{{1,2,3},{4,5,6},{1,1,3}}");
        Var var2 = Var.createVar("{{7,8,9},{19,11,50},{1,1,1}}");
        String expected = "{{48.0, 33.0, 112.0}, {129.0, 93.0, 292.0}, {29.0, 22.0, 62.0}}";
        String actual = var.mul(var2).toString();
        System.out.println();
        System.out.println("testMatrixMulMatrix");
        System.out.println("Expected:  " + expected);
        System.out.println("Actual:    " + actual);
        assertEquals(expected, actual);
    }
}