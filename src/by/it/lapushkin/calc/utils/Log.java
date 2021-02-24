package by.it.lapushkin.calc.utils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Log {
    //TODO : Сделать путь по человечески :)
    private static final String PATHTOLOGFILE = "src/by/it/lapushkin/calc/logs/logs.txt";

    private Log(){
    }
    public static void saveLog(String message) {

        try (OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(PATHTOLOGFILE, true))
        ) {
            outputStream.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearLog();
    }

    private static void clearLog() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(PATHTOLOGFILE))

        ) {
            List<String> lines = new ArrayList<>();
            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine());
            }
            if (lines.size() > 50) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATHTOLOGFILE))
                ) {
                    for (int i = 1; i < lines.size(); i++) {
                        bufferedWriter.write(lines.get(i));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());

        }
    }
}
