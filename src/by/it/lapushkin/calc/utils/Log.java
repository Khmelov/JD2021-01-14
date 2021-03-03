package by.it.lapushkin.calc.utils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Log {
    private static volatile Log logInstance;
    private final String PATHTOLOGFILE = "src/by/it/lapushkin/calc/logs/logs.txt";

    private Log() {
    }

    public static Log getInstance() {
        Log localInstance = logInstance;
        if (localInstance == null) {
            synchronized (Log.class) {
                localInstance = logInstance;
                if (localInstance == null) {
                    logInstance = localInstance = new Log();
                }
            }
        }
        return localInstance;
    }


    public void saveLog(String message) {

        try (OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(PATHTOLOGFILE, true))
        ) {
            outputStream.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearLog();
    }

    private void clearLog() {
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
