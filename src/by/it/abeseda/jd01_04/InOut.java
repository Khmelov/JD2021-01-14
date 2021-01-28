/**
 * @param str;
 * @return double;
 * @deprecated — указывает, что метод или класс - устаревший
 * у него есть более совершенный аналог;
 * @link – гиперссылка, пишется в {  }
 * @author Беседа Александра;
 * @version — задает номер версии класса;
 * @since — определяет версию, с которой элемент
 * (член класса или весь класс) присутствует;
 * @throws — описывает исключение, генерируемое методом;
 * @exception — то же. Задает имя класса исключения;
 * @see — что следует посмотреть дополнительно.
 */

package by.it.abeseda.jd01_04;

public class InOut {
    static double[] getArray(String line) {

        line = line.trim();
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;

    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }
}

