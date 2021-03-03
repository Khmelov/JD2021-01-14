package by.it.zevalich.jd02_04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    public static final String TXT = "vars.txt";
    private static Map<String, Var> vars = new HashMap<>();


    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else {
            Var var = vars.get(strVar);
            if (var == null) {
                throw new CalcException("Incorrect var " + strVar);
            }
            return var;
        }
    }

    static Var save(String name, Var var) {
        vars.put(name, var);
        saveToFile();
        return var;
    }

    private static void saveToFile() {
        String txt = TXT;
        try (PrintWriter writer = new PrintWriter(txt)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void loadMap() throws CalcException {
        String txt = TXT;
        Parser parser = new Parser();
        if (new File(txt).exists())
            try (BufferedReader reader = new BufferedReader(new FileReader(txt))) {
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
        throw new CalcException(String.format(
                "Operation %s + %s incorrect\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(
                "Operation %s - %s incorrect\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(
                "Operation %s * %s incorrect\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(
                "Operation %s / %s incorrect\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}