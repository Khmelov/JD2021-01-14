package by.it.lapushkin.jd01_15;


import by.it.lapushkin.jd01_14.TaskB;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    static StringBuilder path = new StringBuilder(Util.getPath(TaskC.class));

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!(line = reader.readLine()).equals("end")) {
                if (line.equals("dir")) {
                    showDir(new File(path.toString()));
                }

                line = line.replaceFirst("cd", "").trim();
                System.out.println(line);
                if (line.equals("..")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String[] strings = path.toString().split("\\\\");
                    for (int i = 0; i < strings.length - 1; i++) {
                        stringBuilder.append(strings[i]).append(File.separator);
                    }
                    path = stringBuilder;
                    System.out.println(stringBuilder.toString());
                }else {
                    if (new File(path.toString()+line).exists()){
                        path.append(File.separator).append(line);
                    }

                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    static void showDir(File file) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if (file.isFile()) {
            System.out.printf("%10s %5s %10d %-20s \n", dateFormat.format(file.lastModified()), "<FILE>", file.length(), file.getName());
        }
        if (file.isDirectory()) {
            System.out.printf("%10s %5s %10d  %-20s \n", dateFormat.format(file.lastModified()), "<DIR>", file.length(), file.getName());
            File[] files = file.listFiles();
            for (File value : files) {
                showDir(value);
            }
        }

    }
}
