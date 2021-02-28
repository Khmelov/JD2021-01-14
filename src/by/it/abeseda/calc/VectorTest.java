package by.it.abeseda.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }//это аналогічно еслі б мы в начале создали Parser parser=new Parser();

    @Test
    public void vectorAddScalar() throws Exception {
        String result=parser.calc("A={1,2,4.5}+10").toString();
        assertEquals("{11.0, 12.0, 14.5}", result);
    }

    @Test
    public void vectorAddVector() throws Exception  {
        String result=parser.calc("A={1,2,3}+{1,2,3}").toString();
        assertEquals("{2.0, 4.0, 6.0}", result);
    }

    @Test
    public void vectorSubScalar() throws Exception {
        String result=parser.calc("A={1,2,4.5}-1").toString();
        assertEquals("{0.0, 1.0, 3.5}", result);
    }

    @Test
    public void vectorSubVector() throws Exception  {
        String result=parser.calc("A={1,2,3}-{1,2,3}").toString();
        assertEquals("{0.0, 0.0, 0.0}", result);
    }
    @Test
    public void vectorMulScalar() throws Exception {
        String result=parser.calc("A={1,2,4.5}*10").toString();
        assertEquals("{10.0, 20.0, 45.0}", result);
    }

    @Test
    public void vectorMulVector() throws Exception {
        String result=parser.calc("A={2,3,4}*{1,2,3}").toString();
        assertEquals("20.0", result);
    }

    @Test(expected =CalcException.class)
    public void vectorMulVectorDifferentLength() throws Exception {
        parser.calc("A={2,3,4}*{1,2,3,33,44,55}");
        fail();
    }

    @Test
    public void vectorDivScalar() throws Exception  {
        String result=parser.calc("A={1,2,4.5}/10").toString();
        assertEquals("{0.1, 0.2, 0.45}", result);
    }

    @Test(expected =CalcException.class)
    public void vectorDivScalarNull() throws Exception  {
        parser.calc("A={1,2,4.5}/0");
        fail();
    }
}