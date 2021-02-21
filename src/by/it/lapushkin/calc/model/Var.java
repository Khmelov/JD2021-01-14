package by.it.lapushkin.calc.model;


import by.it.lapushkin.calc.model.support.CalcException;
import by.it.lapushkin.calc.utils.Parser;
import by.it.lapushkin.calc.utils.Patterns;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operations {
    //TODO : Сделать путь по человечески :)
    public static final String TXT = "src/by/it/lapushkin/calc/repository/vars.txt";
    private static final Map<String, Var> vars = new HashMap<>();

    public static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else
            throw new CalcException("ERROR: Incorrect input Var");
    }

    public static Var save(String name, Var value) {
        vars.put(name, value);
        saveToFile();
        return value;
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(TXT)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadMap() throws CalcException {
        Parser parser = new Parser();
        try (BufferedReader reader = new BufferedReader(new FileReader(TXT))) {
            for (; ; ) {
                String line = reader.readLine();
                if (line == null) break;
                parser.parse(line);
            }
        } catch (IOException e) {
            throw new CalcException(e);
        }
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        throw new CalcException("Sum Error");
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        throw new CalcException("Sum Error");
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        throw new CalcException("Sum Error");
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        throw new CalcException("Sub Error");
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        throw new CalcException("Sub Error");
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        throw new CalcException("Sub Error");
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        throw new CalcException("Mul Error");
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        throw new CalcException("Mul Error");
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        throw new CalcException("Mul Error");
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        throw new CalcException("Div Error");
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        throw new CalcException("Div Error");
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        throw new CalcException("Div Error");
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
