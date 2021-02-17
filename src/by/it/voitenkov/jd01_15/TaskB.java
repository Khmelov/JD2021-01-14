package by.it.voitenkov.jd01_15;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * dsd
 */

public class TaskB {

    // Комментарий строчный 2
    int a3 = 1;/*
    Комментарий многострочный:
    строка 11
    строка 12
*/
    int a2 = 1;
    int a = 1;/*
    Комментарий многострочный:
    строка 21
    строка 22
    строка 23
    строка 24
    строка 25
     */
    int a1 = 1;

    // Комментарий строчный 2
    public static void main(String[] args) {
        readFileJava();
    }

    static void readFileJava() {
        StringBuilder stringBuffer = new StringBuilder();
        File file = getFile(TaskB.class, "TaskB.java");
        Path path = Paths.get(file.toString());
        try {
            BufferedReader inputStreamReader = new BufferedReader(new FileReader(file));
            String str;
            boolean flagComment = false;
            boolean flagJavaDOC = false;
            boolean flag = false;

            while ((str = inputStreamReader.readLine()) != null) {

                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '/' && chars[i + 1] == '/') {
                        flag = false;
                        break;
                    } else if (str.length() - i > 2 && chars[i] == '/' && chars[i + 1] == '*' && chars[i + 2] == '*' || flagJavaDOC) {
                        if (!flagJavaDOC) {
                            flagJavaDOC = true;
                            break;
                        }
                        while (flagJavaDOC) {
                            if (chars[i] == '*' && chars[i + 1] == '/') {
                                flagJavaDOC = false;
                                i += 2;
                                if (i == str.length() - 1) {
                                    stringBuffer.append(str.substring(i)).append("\n");
                                } else {
                                    stringBuffer.append(str.substring(i));
                                }
                            } else {
                                i++;
                            }
                            if (i == chars.length - 1) {
                                break;
                            }
                        }
                    } else if (chars[i] == '/' && chars[i + 1] == '*' || flagComment) {
                        flagComment = true;
                        while (flagComment) {
                            if (chars[i] == '*' && chars[i + 1] == '/') {
                                flagComment = false;
                                i += 2;
                                if (i == str.length() - 1) {
                                    stringBuffer.append(str.substring(i));
                                } else {
                                    stringBuffer.append(str.substring(i)).append("\n");
                                }

                            } else {
                                i++;
                            }

                            if (i == str.length() - 1) {
                                break;
                            }

                        }
                    } else {
                        stringBuffer.append((char) chars[i]);
                        flag = true;
                    }
                }

                if (flag) {
                    stringBuffer.append("\n");
                    flag = false;
                }
            }
        } catch (
                IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        System.out.println(stringBuffer.toString());

        writeFile(stringBuffer);

    }

    private static void writeFile(StringBuilder str) {
        File file = getFile(TaskA.class, "TaskB.txt");
        try (BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(file))) {
            fileOutputStream.write(str.toString());
            fileOutputStream.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFile(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String root = System.getProperty("user.dir");
        String dir = root +
                File.separator +
                "src" +
                File.separator +
                packageName.replace(".", File.separator);
        return new File(dir, fileName);
    }
}
