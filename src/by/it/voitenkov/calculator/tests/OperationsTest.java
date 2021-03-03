package by.it.voitenkov.calculator.tests;

import by.it.voitenkov.calculator.CalcException;
import by.it.voitenkov.calculator.Parser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void TestScalarAddScalar() throws CalcException {
        String expression = "A=7+2*2";
        double expected = 11;
        double actual = Double.parseDouble(parser.parse(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void TestScalarSubScalar() throws CalcException {
        String expression = "A=7-2-2";
        double expected = 3;
        double actual = Double.parseDouble(parser.parse(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void TestScalarDivScalar() throws CalcException {
        String expression = "A=2/2";
        double expected = 1;
        double actual = Double.parseDouble(parser.parse(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void TestScalarMulScalar() throws CalcException {
        String expression = "A=2*8";
        double expected = 16;
        double actual = Double.parseDouble(parser.parse(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }

    //проверка векторов

    @Test
    public void testCreateVector() throws CalcException {
        assertEquals("{-3.0, -6.0, -8.0, -2.8, 1.0}",
                parser.parse("R={-3,-6,-8, -2.8, 1.00}").toString());
    }

    @Test
    public void testVectorAddScalar() throws CalcException {
        assertEquals("{7.0, 8.0, 10.0}",
                parser.parse("R={2, 3, 5} + 5").toString());
    }

    @Test
    public void testVectorAddVector() throws CalcException {
        assertEquals("{4.0, 6.0, 10.0}",
                parser.parse("R={2, 3, 5} + {2, 3, 5}").toString());
    }

    @Test
    public void testVectorSubScalar() throws CalcException {
        assertEquals("{1.0, 2.0, 4.0}",
                parser.parse("R={2, 3, 5} - 1").toString());
    }

    @Test
    public void testVectorSubVector() throws CalcException {
        assertEquals("{1.0, 2.0, 4.0}",
                parser.parse("R={2, 3, 5} - {1, 1, 1}").toString());
    }

    @Test
    public void testVectorMulScalar() throws CalcException {
        assertEquals("{10.0, 15.0, 25.0}",
                parser.parse("R={2, 3, 5} * 5").toString());
    }

    @Test
    public void testVectorMulVector() throws CalcException {
        assertEquals("38.0",
                parser.parse("R={2, 3, 5} * {2, 3, 5}").toString());
    }

    @Test
    public void testVectorDivScalar() throws CalcException {
        assertEquals("{2.0, 3.0, 5.0}",
                parser.parse("R={20, 30, 50} / 10").toString());
    }

//    @Test
//    public void testVectorMulVectorDifferentLengths() throws CalcException {
//        assertEquals("Длина двух векторов должна быть равна!",
//                parser.parse("R={2, 3, 5} * {2, 3, 5, 2, 2, 2}").toString());
//    }

//    @Test
//    public void testVectorMulDivisionByZero() throws CalcException {
//        assertEquals("ошибка", parser.parse("R={2, 3, 5} / 0").toString());
//    }

    // проверка матриц

    private final String MATRIX1 = "{{1,2,3},{4,5,6},{7,8,9}}";
    private final String MATRIX2 = "{{10,20,30},{40,50,60},{70,80,90}}";
    private final String MATRIX3 = "{{10,20,30},{40,50,60}'";
    private final String SCALAR = "5.0";
    private final String VECTOR1 = "{-1,-1,-1}";
    private final String VECTOR2 = "{-1,-1,-1,-1}";

    @Test
    public void testCreateMatrix() throws CalcException {
        assertEquals("{{-1.0, 12.0, -11.5}, {0.0, 0.0, 3.0}, {5.0, 12.0, -7.0}}",
                parser.parse("M={{-1,12, -11.5}, {0,0, 3},{5,12,-7}}").toString());
    }

    @Test
    public void matrixAddScalar() throws CalcException {
        assertEquals("{{4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}, {10.0, 11.0, 12.0}}",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} + 3.0").toString());
    }

    @Test
    public void matrixAddMatrixOneSize() throws CalcException {
        assertEquals("{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} + {{1,2,3},{4,5,6},{7,8,9}}").toString());
    }

//    @Test
//    public void matrixAddMatrixDifferentSize() throws CalcException {
//        assertEquals("Матрицы разных размеров!",
//                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} + {{1,2,3},{4,5,6}}").toString());
//    }

    @Test
    public void matrixSubScalar() throws CalcException {
        assertEquals("{{-2.0, -1.0, 0.0}, {1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} - 3.0").toString());
    }

//    @Test
//    public void matrixSubMatrixOneSize() throws CalcException {
//        assertEquals("Матрицы разного размера. Вычесть невозможно!",
//                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} - {{10,20,30},{40,50,60},{70,80,90}}").toString());
//    }

//    @Test
//    public void matrixSubMatrixDifferentSize() throws CalcException {
//        assertEquals("матрицы разного размера!",
//                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} - {{10,20,30},{40,50,60}}").toString());
//
//    }

    @Test
    public void matrixMulScalar() throws CalcException {
        assertEquals("{{3.0, 6.0, 9.0}, {12.0, 15.0, 18.0}, {21.0, 24.0, 27.0}}",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} * 3.0").toString());
    }

    @Test
    public void matrixMulMatrixOneSize() throws CalcException {
        assertEquals("{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} * {{1,2,3},{4,5,6},{7,8,9}}").toString());
    }

    @Test(expected = CalcException.class)
    public void matrixMulMatrixDifferentSize() throws CalcException {
        assertEquals("1",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} * {{1,2,3},{4,5,6}").toString());
    }

    @Test
    public void matrixMulVectorOneSize() throws CalcException {
        assertEquals("{-20.0, -47.0, -74.0}", parser.parse("{{1,2,3},{4,5,6},{7,8,9}} * {-2,-3,-4}").toString());
    }

    @Test
    public void matrixMulVectorDifferentSize() throws CalcException {
        assertEquals("{-20.0, -47.0, -74.0}",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} *  {-2,-3,-4}").toString());
    }

    @Test
    public void matrixDivScalar() throws CalcException {
        assertEquals("{{0.25, 0.5, 0.75}, {1.0, 1.25, 1.5}, {1.75, 2.0, 2.25}}",
                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} / 4.0").toString());
    }

//    @Test
//    public void matrixDivScalarDivisionByZero() throws CalcException {
//        assertEquals("деление на ноль",
//                parser.parse("{{1,2,3},{4,5,6},{7,8,9}} / 0 ").toString());
//    }

    @After
    public void tearDown() {
        System.out.println("проверка закончена");
    }
}