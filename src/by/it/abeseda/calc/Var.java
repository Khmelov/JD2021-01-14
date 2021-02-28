package by.it.abeseda.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    public static final String TXT = "vars.txt";
    private static final Map<String, Var> vars = new HashMap<>();

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand); }
        else if(vars.containsKey(operand)) {
            return vars.get(operand);
        }else{
            throw new CalcException("Вот тут косяк " + operand);
        }
    }

    static Var saveVar(String name, Var var){
        vars.put(name, var);
        saveToFile();
        return var;
    }

    private static void saveToFile() {
        try(PrintWriter writer=new PrintWriter(TXT)){
            for (Map.Entry<String, Var> entry: vars.entrySet()){
                writer.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void loadMap() throws CalcException{
        Parser parser=new Parser();
        try (BufferedReader reader=new BufferedReader(new FileReader(TXT)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                parser.calc(line);
            }
        }
        catch (IOException e) {
            throw new CalcException(e);
        }
    }


    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция сложения:"+this+"+"+other+" невозможна.");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания:"+this+"-"+other+" невозможна.");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения:"+this+"*"+other+" невозможна.");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления:"+this+"/"+other+" невозможна.");
    }

    @Override
    public String toString() {
        return "Это астрактный класс Var.";
    }
}