package by.it.voitenkov.jd01_06;

public class TaskC1 {

    public static void main(String[] args) {
        String str = calculateLineSize();
        System.out.println(str);
    }

    static String calculateLineSize() {
        String[] arrayLines = Poem.text.split("\n");
        int maxSize = 0;
        for (String element : arrayLines) {
            if (element.length() > maxSize) {
                maxSize = element.length();
            }
        }
        return lineLengthWithoutSpace(arrayLines, maxSize);
    }

    static String lineLengthWithoutSpace(String[] array, int maxSize) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(array[i]);
            int start = stringBuilder.indexOf(" ");
            int count = 2;

            while (stringBuilder.length() != maxSize) {
                stringBuilder.insert(stringBuilder.indexOf(" ", start), " ");
                if (stringBuilder.indexOf(" ", start + count) != -1) {
                    start = stringBuilder.indexOf(" ", start + count);
                } else {
                    count++;
                    start = stringBuilder.indexOf(" ");
                }
            }
            array[i] = stringBuilder.toString();
        }

        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                str.append(array[i]).append('\n');
            } else {
                str.append(array[i]);
            }
        }
        return str.toString();
    }
}