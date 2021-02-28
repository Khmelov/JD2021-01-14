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
    public void addVector() throws Exception {
        String expession="{1,2}+{3,4}";
//        String result="{4.0, 6.0}";

    }

    @Test
    public void sub() throws Exception  {
    }

    @Test
    public void mul() throws Exception  {
    }

    @Test
    public void div() throws Exception  {
    }
}