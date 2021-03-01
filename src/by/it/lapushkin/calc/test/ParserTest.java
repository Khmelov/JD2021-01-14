package by.it.lapushkin.calc.test;
import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.model.support.CalcException;
import by.it.lapushkin.calc.utils.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserTest {
    private Parser parser;

    @Before
    public void setUp() throws CalcException {
        parser = new Parser();
        Var.loadMap();
    }

    @Test
    public void test() throws CalcException{
        String string = "A=2+5.3";
        String expected= "7.3";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);
    }
    @Test
    public void test_step_2() throws CalcException{
        String string = "B=A*3.5";
        String expected= "25.55";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);
    }
    @Test
    public void test_step_3() throws CalcException{
        String string = "B1=B+0.11*-5";
        String expected= "25.0";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);
    }
    @Test
    public void test_step_4() throws CalcException{
        String string = "B2=A/2-1";
        String expected= "2.65";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);
    }
    @Test
    public void test_step_5() throws CalcException{
        String string = "C=B+(A*2)";
        String expected= "40.15";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);
    }
    @Test
    public void test_step_6() throws CalcException{
        String string = "D=((C-0.15)-20) / (7-5)";
        String expected= "10.0";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);
    }
    @Test
    public void test_step_7() throws CalcException{
        String string = "E={2,3}*(D/2)";
        String expected= "{10.0,15.0}";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);
    }
    @Test
    public void test_step_8()throws CalcException{
        //матрица умножается на скаляр
        String string = "V={{2,3},{3,5}}*E";
        String expected= "{65.0,105.0}";
        String actual = parser.parse(string).toString();
        assertEquals(expected,actual);

    }




}