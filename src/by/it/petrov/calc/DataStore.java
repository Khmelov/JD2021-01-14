package by.it.petrov.calc;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private static Map<String, Var> variables = new HashMap<>();

    public static void printVar(){
        for (int i = 0; i < variables.size(); i++) {
            System.out.println(variables.keySet().toArray()[i] + "=" + variables.values().toArray()[i]);
        }
        System.out.println(variables.entrySet());
    }

    public static Var getVariable(Var variable) {
        return variables.get(variable);
    }

    public static void setVariable(String variable, Var value) {
        DataStore.variables.put(variable, value);
        System.out.println(variables);
    }
}
