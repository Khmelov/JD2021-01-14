package by.it.petrov.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    static ArrayList<Integer> integerArrayList = new ArrayList<>();

    private static String dir(Class<?> cl) {
        String dirName = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String dirUser = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        System.out.println(dirName + dirUser);
        return dirName + dirUser;
    }

    public static void main(String[] args) {

        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")))
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")))
        ) {
            while (inp.available() > 0) {
                integerArrayList.add(inp.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double sum = 0;
        int count = integerArrayList.size();

        System.out.println(integerArrayList);
        for (int i = 0; i < integerArrayList.size(); i++) {
            System.out.print(" " + integerArrayList.get(i));
            sum += integerArrayList.get(i);
        }
        double avg = sum / count;
        System.out.println("avg=" + avg);

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))
        ) {
            for (int i = 0; i < integerArrayList.size(); i++) {
                pw.write(" " + integerArrayList.get(i));
            }
            pw.write("avg=" + avg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
