package by.it._akhmelov_.jd01_04;

public class InOut {
    static double[ ] getArray(String line){
        //1 3 5 88 99
        line = line.trim();
        String[] stringValues = line.split(" ");
        double[] result=new double[stringValues.length];
        for (int i = 0; i < result.length; i++) {
            result[i]=Double.parseDouble(stringValues[i]);
        }
        return result;
    }

    static void printArray(double[] array){
        for (double element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String  name, int columnCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,array[i]);
            if ((i+1)%columnCount==0 || i==array.length-1){
                System.out.println();
            }
        }
    }

}
