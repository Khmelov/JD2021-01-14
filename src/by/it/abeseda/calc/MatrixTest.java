package by.it.abeseda.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private final String MATRIX1="{{1,2,3},{4,5,6},{7,8,9}}";
    private final String MATRIX2="{{10,20,30},{40,50,60},{70,80,90}}";
    private final String MATRIX3 ="{{10,20,30},{40,50,60}'";
    private final String SCALAR ="5.0";
    private final String VECTOR1 ="{-1,-1,-1}";
    private final String VECTOR2 ="{-1,-1,-1,-1}";

    Parser parser=new Parser();

    @Test
    public void testCreateMatrix() throws CalcException {
        parser.calc("M={{-1.22,123.58, -16}, {0,0, 0.012},{0,-16,-8.55}}");
        String result = parser.calc("M").toString();
        assertEquals("{{-1.22, 123.58, -16.0}, {0.0, 0.0, 0.012}, {0.0, -16.0, -8.55}}", result);
    }

    @Test
    public void matrixAddScalar() throws CalcException {
        String result=parser.calc(MATRIX1+"+"+ SCALAR).toString();
        String expected="{{6.0, 7.0, 8.0}, {9.0, 10.0, 11.0}, {12.0, 13.0, 14.0}}";
        assertEquals(expected,result);
    }

    @Test
    public void matrixAddMatrixOneSize() throws CalcException {
        String result=parser.calc(MATRIX1+"+"+MATRIX2).toString();
        String expected="{{11.0, 22.0, 33.0}, {44.0, 55.0, 66.0}, {77.0, 88.0, 99.0}}";
        assertEquals(expected,result);
    }

    @Test (expected=CalcException.class)
    public void matrixAddMatrixDifferentSize() throws CalcException {
        parser.calc(MATRIX1+"+"+ MATRIX3);
        fail();
    }

    @Test
    public void matrixSubScalar() throws CalcException {
        String result=parser.calc(MATRIX1+"-"+ SCALAR).toString();
        String expected="{{-4.0, -3.0, -2.0}, {-1.0, 0.0, 1.0}, {2.0, 3.0, 4.0}}";
        assertEquals(expected,result);
    }


    @Test
    public void matrixSubMatrixOneSize() throws CalcException {
        String result=parser.calc(MATRIX1+"-"+MATRIX2).toString();
        String expected="{{-9.0, -18.0, -27.0}, {-36.0, -45.0, -54.0}, {-63.0, -72.0, -81.0}}";
        assertEquals(expected,result);
    }


    @Test (expected=CalcException.class)
    public void matrixSubMatrixDifferentSize() throws CalcException {
        parser.calc(MATRIX1+"+"+ MATRIX3);
        fail();
    }

    @Test
    public void matrixMulScalar() throws CalcException {
        String result=parser.calc(MATRIX1+"*"+ SCALAR).toString();
        String expected="{{5.0, 10.0, 15.0}, {20.0, 25.0, 30.0}, {35.0, 40.0, 45.0}}";
        assertEquals(expected,result);
    }

    @Test
    public void matrixMulMatrixOneSize() throws CalcException {
        String result=parser.calc(MATRIX1+"*"+MATRIX2).toString();
        String expected="{{300.0, 360.0, 420.0}, {660.0, 810.0, 960.0}, {1020.0, 1260.0, 1500.0}}";
        assertEquals(expected,result);
    }

    @Test (expected=CalcException.class)
    public void matrixMulMatrixDifferentSize() throws CalcException {
        parser.calc(MATRIX1+"*"+ MATRIX3);
        fail();
    }

    @Test
    public void matrixMulVectorOneSize() throws CalcException {
        String result=parser.calc(MATRIX1+"*"+ VECTOR1).toString();
        String expected="{-6.0, -15.0, -24.0}";
        assertEquals(expected,result);
    }

    @Test (expected=CalcException.class)
    public void matrixMulVectorDifferentSize() throws CalcException {
        parser.calc(MATRIX1+"*"+ VECTOR2);
        fail();
    }

    @Test
    public void matrixDivScalar() throws CalcException {
        String result=parser.calc(MATRIX1+"/"+ SCALAR).toString();
        String expected="{{0.2, 0.4, 0.6}, {0.8, 1.0, 1.2}, {1.4, 1.6, 1.8}}";
        assertEquals(expected,result);
    }

    @Test (expected=CalcException.class)
    public void matrixDivScalarNull() throws CalcException {
        parser.calc(MATRIX1+"/"+ 0);
        fail();
    }
}