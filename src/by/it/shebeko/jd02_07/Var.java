package by.it.shebeko.jd02_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class Var implements Operation {
    private static final Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVarMap() {
        return vars;
    }

    static void saveVar(String name, Var var) {
        vars.put(name, var);
    }

    static void load() throws CalcException {
        try {
            List<String> lines = Files.lines(Paths.get(GetFileName.getFilename())).collect(Collectors.toList());
            Parser parser = new Parser();
            for (String line : lines) {
                parser.calc(line);
            }
        } catch (IOException e) {
            throw new CalcException(e);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Operation add " + this + " + " + other + " doesn't work");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Operation sub " + this + " - " + other + " doesn't work");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Operation mul " + this + " * " + other + " doesn't work");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Operation div " + this + " / " + other + " doesn't work");
    }

}
