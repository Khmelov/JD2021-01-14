package by.it.vesniachok.jd01_04;

public class InOut {
    static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }

        return result;
    }

    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.4f ", name, i, array[i]);
            if (i == columnCount || (array.length - 1 == i)) {

                System.out.println();
            }
        }
    }
}
