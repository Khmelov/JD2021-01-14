package by.it.lapushkin.calc.test;

import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.model.support.CalcException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ErrorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void testDivisionByZero() throws CalcException {
        expectedException.expect(CalcException.class);
        expectedException.expectMessage("division by zero");
        Var var = Var.createVar("2");
        Var rav = Var.createVar("0");
        var.div(rav);
    }
    @Test
    public void testIncorrectInput() throws CalcException {
        expectedException.expect(CalcException.class);
        expectedException.expectMessage("incorrect input");
        Var.createVar("asd");
    }
    @Test
    public void testIncorrectLengthVector() throws CalcException {
        expectedException.expect(CalcException.class);
        expectedException.expectMessage("incorrect length");
        Var var = Var.createVar("{1,2,3,4}");
        Var rav = Var.createVar("{1,2,3}");
        var.mul(rav);
    }
}
