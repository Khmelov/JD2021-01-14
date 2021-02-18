package by.it.shebeko.jd01_14;

import java.io.*;

public class TaskA {   //можно с константами

    private static String dir(Class<?> c1){
        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String c1Dir=c1.getName().replace(c1.getSimpleName(), "").replace(".", File.separator);
        return path+c1Dir;
    }

    public static void main(String[] args) {
        DataOutputStream dos=null;
        try {
            dos=new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")));

            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*20));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (dos!=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (DataInputStream input=new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
             PrintWriter out2=new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))){
            double sum=0;
            double count=0;
            while (input.available()>0){
                int i=input.readInt();
                System.out.print(i+" ");
                out2.print(i+" ");
                sum=sum+i;
                count++;
            }
            System.out.print("\navg="+sum/count);
            out2.print("\navg="+sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
