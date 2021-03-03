package by.it.voitenkov.calculator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {
    public static String TXT_FILE = "src/by/it/voitenkov/calculator/txt/result.txt";
    private static final Map<String, Var> vars = new HashMap<>();

    static Var createVar(String lineVar) throws CalcException {
        lineVar = lineVar.trim().replaceAll("\\s+", "");
        if (lineVar.matches(Patterns.SCALAR)) {
            return new Scalar(lineVar);
        }
        if (lineVar.matches(Patterns.VECTOR)) {
            return new Vector(lineVar);
        }
        if (lineVar.matches(Patterns.MATRIX)) {
            return new Matrix(lineVar);
        } else {
            Var calc = vars.get(lineVar);
            if (calc == null) {
                throw new CalcException("Ошибка в " + calc);
            }
            return calc;
        }
    }

    static Var save(String name, Var var) {
        vars.put(name, var);
        saveToFile();
        return var;
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(TXT_FILE)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void loadMap() throws CalcException {
        Parser parser = new Parser();

        try (BufferedReader reader = new BufferedReader(new FileReader(TXT_FILE))) {
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
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения:" + this + "+" + other + " не возможна.");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + " - " + other + " не возможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * " + other + " не возможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / " + other + " не возможна");
    }
}