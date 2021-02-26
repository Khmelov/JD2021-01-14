package by.it.abeseda.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    private Parser parser;

    @Before// запускается перед каждым тестовым методом
    //сначала мы запускаем класс парсер, потом только у нас все работает
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void add()throws Exception {
        String expression = "A=2+2*2";
        double expected = 6.0;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }
// Метод assertEquals() проверяет на равенство значений expected и
//actual с возможной погрешностью delta. При выполнении заданных
//условий сообщает об успешном завершении, в противном случае —
//об аварийном завершении теста. При аварийном завершении
//генерируется ошибка java.lang.AssertionError.
    @Test
    public void sub()throws Exception {
        String expression = "A=2-2*2";
        double expected = -2.0;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void mul() throws Exception {
        String expression = "A=2*2";
        double expected = 4.0;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void div() throws Exception {
        String expression = "A=2/2";
        double expected = 1.0;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals(expected, actual, 1e-10);
    }
}