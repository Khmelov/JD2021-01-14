package by.it.voitenkov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clazzDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return (path + clazzDir);
    }

    public static void main(String[] args) {
        DataOutputStream dataOutputStream = null;
        List<Integer> list = new ArrayList<>();
        int count = 20;
        try {
            dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")));
            while (count >= 0) {
                dataOutputStream.writeInt(randomNumber());
                count--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter printWriter = new PrintWriter(dir(TaskA.class) + "resultTaskA.txt")) {
            double sum = 0;
            double counter = 0;
            while (inp.available() > 0) {

                int i = inp.readInt();
                System.out.print(i + " ");
                sum += i;
                counter++;
            }
            System.out.println("\navg=" + sum / (counter + 0.0));
            printWriter.print("\navg=" + sum / (counter + 0.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int randomNumber() {
        return (int) (Math.random() * 20);
    }
}