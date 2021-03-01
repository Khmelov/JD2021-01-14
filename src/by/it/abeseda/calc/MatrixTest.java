package by.it.abeseda.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private String matrix1="{{1,2,3},{4,5,6},{7,8,9}}";
    private String matrix2="{{10,20,30},{40,50,60},{70,80,90}}";
    private String matrix3="{{10,20,30},{40,50,60}'";
    private String scalar="5.0";
    private String vector1="{-1,-1,-1}";
//    private String vector2;

    Parser parser=new Parser();

    @Test
    public void matrixAddScalar() throws CalcException {
        String result=parser.calc(matrix1+"+"+scalar).toString();
        String expected="{{6.0, 7.0, 8.0}, {9.0, 10.0, 11.0}, {12.0, 13.0, 14.0}}";
        assertEquals(expected,result);
    }

    @Test
    public void matrixAddMatrixOneSize() throws CalcException {
        String result=parser.calc(matrix1+"+"+matrix2).toString();
        String expected="{{11.0, 22.0, 33.0}, {44.0, 55.0, 66.0}, {77.0, 88.0, 99.0}}";
        assertEquals(expected,result);
    }

    @Test (expected=CalcException.class)
    public void matrixAddMatrixDifferentSize() throws CalcException {
        parser.calc(matrix1+"+"+matrix3).toString();
        fail();
    }

//    @Test
//    public void matrixSubScalar() throws CalcException {
//        String result=parser.calc(matrix1+"-"+scalar).toString();
//        String expected="{{-4.0, -3.0, -2.0}, {-1.0, 0.0, 1.0}, {2.0, 3.0, 4.0}}";
//        assertEquals(expected,result);
//    }
//
//
//    @Test
//    public void matrixSubMatrixOneSize() throws CalcException {
//        String result=parser.calc(matrix1+"-"+matrix1).toString();
//        String expected="{{0.0, -18.0, -27.0}, {-36.0, -45.0, -54.0}, {-63.0, -72.0, -81.0}}";
//        assertEquals(expected,result);
//    }
//
//
//
    @Test (expected=CalcException.class)
    public void matrixSubMatrixDifferentSize() throws CalcException {
        parser.calc(matrix1+"+"+matrix3);
        fail();
    }




    @Test
    public void mul() {
    }

    @Test
    public void div() {
    }
}