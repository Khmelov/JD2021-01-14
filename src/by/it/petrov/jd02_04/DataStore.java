package by.it.petrov.jd02_04;

import java.util.HashMap;
import java.util.TreeMap;

public class DataStore {

    private static HashMap<String, Var> variables = new HashMap<>();

    public  static void sortVar(){
        TreeMap<String, Var> sorted = new TreeMap<>(variables);
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.keySet().toArray()[i] + "=" + sorted.values().toArray()[i]);
        }
    }

    public static void printVar(){
        for (int i = 0; i < variables.size(); i++) {
            System.out.println(variables.keySet().toArray()[i] + "=" + variables.values().toArray()[i]);
        }
    }

    public static Var getVariable(String variable) {
        return variables.get(variable);
    }

    public static void setVariable(String variable, Var value) {
        DataStore.variables.put(variable, value);
    }
}
