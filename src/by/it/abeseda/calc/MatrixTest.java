package by.it.abeseda.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private String matrix1="{{1,2,3},{4,5,6},{7,8,9}}";
    private String matrix2="{{10,20,30},{40,50,60}'";
    private String scalar="5.0";
    private String vector1="{-1,-1,-1}";
//    private String vector2;

    Parser parser=new Parser();

    @Test
    public void matrixAddScalar() throws CalcException {
        String result=parser.calc(matrix1+"+"+scalar).toString();
        String expected="{{6.0, 7.0, 8.0} ,{9.0, 10.0, 11.0} ,{12.0, 13.0, 14.0}}";
        assertEquals(expected,result);
    }

    @Test
    public void sub() {
    }

    @Test
    public void mul() {
    }

    @Test
    public void div() {
    }
}