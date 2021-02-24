package by.it.tashtsimirov.jd01_14;

import java.io.*;

public class TaskB {

    private static String dir(Class<?> cls) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clsDir = cls.getName().replace(cls.getSimpleName(),"").replace(".",File.separator);
        return path + clsDir;
    }

    public static void main(String[] args) {

        File f = new File(dir(TaskB.class)+"TaskB.txt");
        FileReader fR = null;
        int b;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbd = new StringBuilder();

        try {
            fR = new FileReader(f);
            while ((b = fR.read()) != -1) {
                char ch = ((char) b);
                String str = Character.toString(ch);
                sbd = sb.append(str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fR != null) {
                try {
                    fR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String sBD = sbd.toString();
        String sBDsplt = sBD.replaceAll("\\s\\s"," ").trim();
        //System.out.print(sBDsplt);

        String[] sbdSplt = sBDsplt.split("[^а-яА-ЯёЁ]+");
        //System.out.print("\n"+Arrays.toString(sbdSplt));
        int words = sbdSplt.length;

        String[] sbdSplt2 = sBDsplt.split("[а-яА-ЯёЁ\\s]+");
        //System.out.print("\n"+Arrays.toString(sbdSplt2));
        int marks = sbdSplt2.length-1;

        System.out.println("\nwords=" + words + ", marks=" + marks);


        try (PrintWriter out3 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskB.txt"))) {
            out3.print("\nwords=" + words + ", marks=" + marks);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
