package by.it.lapushkin.jd01_14;

import java.io.*;

public class TaskC {
    static final String FILENAME_TEXT = "resultTaskC.txt";

    public static void main(String[] args) {
        String path = TaskB.getPath(TaskC.class);
        String name = "lapushkin";
        String nameMyPath = path.split(name)[0];
        File myPath = new File(nameMyPath+name+File.separator);
        printPath(myPath);
    }

    private static void printPath(File file){

        try (OutputStreamWriter outputStream = new OutputStreamWriter(
                new FileOutputStream(
                        TaskB.getPath(TaskC.class)+FILENAME_TEXT))){
            if (file.isFile()){
                String fileName = "file:"+file.getName();
                System.out.println(fileName);
                outputStream.write(fileName+"\n");
            }
            if (file.isDirectory()){
                String dirName = "dir:"+file.getName();
                System.out.println(dirName);
                outputStream.write(dirName+"\n");
                File[] files = file.listFiles();
                for (File value : files) {
                    printPath(value);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
