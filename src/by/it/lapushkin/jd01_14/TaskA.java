package by.it.lapushkin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        File binInt = Util.getFile(TaskA.class, "dataTaskA.bin");
        File txtFile = Util.getFile(TaskA.class, "resultTaskA.txt");
        writeInt(binInt);
        List<Integer> list = readInt(binInt);
        printConsole(list);
        printToFile(txtFile, list);


    }

    private static void printToFile(File txtFile, List<Integer> list) {
        try (PrintWriter writer = new PrintWriter(txtFile)){
            double sum2 = 0;
            for (Integer value : list) {
                sum2 += value;
                writer.print(value + " ");
            }
            writer.println("\navg=" + sum2 / list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printConsole(List<Integer> list) {
        double sum = 0;
        for (Integer value : list) {
            sum += value;
            System.out.print(value + " ");
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static List<Integer> readInt(File binInt) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(binInt))
        )) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static void writeInt(File binInt) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(binInt)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 1000);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
