package by.it.lapushkin.jd01_03;

public class InOut {
    /**
     *
     * @param line String input
     * @return double[] Return array double;
     */
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
    /**
     *
     * @param array Input array
     * @param name Name array
     * @param columnsCount Number of columns
     * @author Pavel Lapushkin
     */
    static void printArray(double[] array, String name, int columnsCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]= %-9.4f ", name, i, array[i]);
            if ((i + 1) == i % columnsCount || (array.length - 1 == i)) {
                System.out.println();
            }

        }

    }
}
