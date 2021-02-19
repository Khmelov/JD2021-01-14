package by.it.voitenkov.jd01_14;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;


public class TaskC {

    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();
        List<String> catalogList = new ArrayList<>();
        searchFiles(new File("src/by/it/voitenkov"), fileList, catalogList);
        fileWriter(fileList, catalogList);
    }

    private static void searchFiles(File rootFile, List<String> fileList, List<String> catalogList) {
        if (rootFile.isDirectory()) {
            catalogList.add("dir:" + rootFile.getName());
            File[] directoryFiles = rootFile.listFiles();
            if  (directoryFiles != null) {
                for(File file: directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList, catalogList);
                    } else {
                        fileList.add("file:" + file.getName());
                    }

                }
            }
        }
    }

    static void fileWriter(List<String> files, List<String> catalogList) {
        File file = Path.of("src", "by", "it", "voitenkov", "jd01_14", "resultTaskC.txt").toFile();

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            for (String fileString: files) {
                outputStream.write(fileString.getBytes(StandardCharsets.UTF_8));
                System.out.println(fileString);
            }

            for (String catalog : catalogList) {
                outputStream.write(catalog.getBytes(StandardCharsets.UTF_8));
                System.out.println(catalog);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}