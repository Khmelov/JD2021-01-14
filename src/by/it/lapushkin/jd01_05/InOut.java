package by.it.lapushkin.jd01_05;

public class InOut {
    static double[] getArray(String line) {
        String[] stringArray = line.trim().split(" ");
        double[] intArray = new double[stringArray.length];
        for (int i = 0, stringArrayLength = stringArray.length; i < stringArrayLength; i++) {
            intArray[i] = Double.parseDouble(stringArray[i]);
        }

        return intArray;
    }

    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.5f ", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || (array.length - 1 == i)) {
                System.out.println();
            }
        }

    }


}

























