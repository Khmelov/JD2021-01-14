package by.it.zevalich.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void testExpressionWithScalars() throws Exception {
        String expression = "A=2+2*2";
        double expected = 6.0;
        double actual = Double.parseDouble(parser.parse(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @After
    public void tearDown() {
        System.out.println("end");
    }
}