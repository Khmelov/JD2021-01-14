package by.it.abeseda.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {


    private Parser parser;

    @Before// запускается перед каждым тестовым методом
    //сначала мы запускаем класс парсер, потом только у нас все работает
    public void setUp() {
        parser = new Parser();
    }


    @Test
    public void add() throws Exception {
        String expression = "A={2,2}*2";
        double[] expected = new double[]{4.0, 4.0};
        double actual = Double.parseDouble(parser.calc(expression).toString());
//        assertEquals(expected[], actual, 1e-10);
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