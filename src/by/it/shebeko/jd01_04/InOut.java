package by.it.shebeko.jd01_04;

public class InOut {

    static double[] getArray(String line) {         //на вход массив принимает строку line c типом string
       line = line.trim();     //убираем пробелы в конце
       String[] strArray = line.split(" ");  // метод сплит  вернет массив строк
       double[] result = new double [strArray.length];  //дабл массив нужен такой же по размеру
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }                                                 //массив из строки преобразовываем в дабл
        return result;
    }


    static void printArray (double[ ] array){
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) %columnCount == 0  || i + 1 == arr.length)
                System.out.println();

        }
    }
}
