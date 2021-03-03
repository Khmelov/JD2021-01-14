package by.it.abeseda.calc_jd02_06_07;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class VectorTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }//это аналогічно еслі б мы в начале создали Parser parser=new Parser();

    @Test
    public void testCreateVector() throws CalcException {
        parser.calc("V={-1,2,4.5, -5.6, 7.00, 678}");
        String res = parser.calc("V").toString();
        assertEquals("{-1.0, 2.0, 4.5, -5.6, 7.0, 678.0}", res);
    }

    @Test
    public void testVectorAddScalar() throws Exception {
        String result=parser.calc("A={1,2,4.5}+10").toString();
        assertEquals("{11.0, 12.0, 14.5}", result);
    }

    @Test
    public void testVectorAddVector() throws Exception  {
        String result=parser.calc("A={1,2,3}+{1,2,3}").toString();
        assertEquals("{2.0, 4.0, 6.0}", result);
    }

    @Test
    public void testVectorSubScalar() throws Exception {
        String result=parser.calc("A={1,2,4.5}-1").toString();
        assertEquals("{0.0, 1.0, 3.5}", result);
    }

    @Test
    public void testVectorSubVector() throws Exception  {
        String result=parser.calc("A={1,2,3}-{1,2,3}").toString();
        assertEquals("{0.0, 0.0, 0.0}", result);
    }
    @Test
    public void testVectorMulScalar() throws Exception {
        String result=parser.calc("A={1,2,4.5}*10").toString();
        assertEquals("{10.0, 20.0, 45.0}", result);
    }

    @Test
    public void testVectorMulVector() throws Exception {
        String result=parser.calc("A={2,3,4}*{1,2,3}").toString();
        assertEquals("20.0", result);
    }

    @Test(expected = CalcException.class)
    public void testVectorMulVectorDifferentLength() throws Exception {
        parser.calc("A={2,3,4}*{1,2,3,33,44,55}");
        fail();
    }

    @Test
    public void testVectorDivScalar() throws Exception  {
        String result=parser.calc("A={1,2,4.5}/10").toString();
        assertEquals("{0.1, 0.2, 0.45}", result);
    }

    @Test(expected = CalcException.class)
    public void testVectorDivScalarNull() throws Exception  {
        parser.calc("A={1,2,4.5}/0");
        fail();
    }
}