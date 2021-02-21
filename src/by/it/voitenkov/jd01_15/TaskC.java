package by.it.voitenkov.jd01_15;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class TaskC {
    private static final String catalog = "voitenkov.jd01_15";
    private static File file = getPath(catalog);

    public static void main(String[] args) {
        readerConsole();
    }

    static void readerConsole() {
        List<String> catalogList = new ArrayList<>();
        List<String> fileList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            String line = scanner.nextLine().toLowerCase(Locale.ROOT);

            if (line.contains("cd")) {
                if (line.matches("cd[\\D A-z]+")) {
                    file = getPath(line.replace("cd", "").trim());
                    if (file.isAbsolute()) {
                        System.out.println(file);
                    } else {
                        System.out.println("Системе не удается найти указанный путь.");
                    }
                    System.out.println();
                } else if (line.matches("cd")) {
                    System.out.println(file.getAbsoluteFile());
                } else if (line.equals("cd\\")) {

                    System.out.println(getPath(catalog));
                } else {
                    System.out.println("\"" + line + "\"" + " не является внутренней или внешней\n"
                            + "командой, исполняемой программой или пакетным файлом.");
                }
            } else if (line.equals("dir")) {
                searchFiles(file, fileList, catalogList);
                printList(fileList);
            } else if (line.equals("end")) {
                isEnd = true;
            }
        }
    }

    private static void searchFiles(File rootFile, List<String> fileList, List<String> catalogList) {
        if (rootFile.isDirectory()) {
            catalogList.add("dir:" + rootFile.getName());
            File[] directoryFiles = rootFile.listFiles();

            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList, catalogList);
                    } else {
                        fileList.add("file:" + file.getName());
                    }
                }
            }
        }
    }

    static File getPath(String catalog) {
        String workFoldersPath = catalog.replace(".", File.separator);
        String workingDirectory = System.getProperty("user.dir");
        String fullPath = workingDirectory + File.separator
                + "src" + File.separator
                + "by" + File.separator
                + "it" + File.separator
                + workFoldersPath;

        return new File(fullPath);
    }

    static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }
}