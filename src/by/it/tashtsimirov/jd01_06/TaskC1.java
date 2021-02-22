package by.it.tashtsimirov.jd01_06;

public class TaskC1 {

    public static void main(String[] args) {

        String poem = Poem.text;
        String[] poemSpl = poem.split("\n");

        boolean isSorted = false;
        String buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < poemSpl.length-1; i++) {
                if(poemSpl[i].length() > poemSpl[i+1].length()){
                    isSorted = false;

                    buf = poemSpl[i];
                    poemSpl[i] = poemSpl[i+1];
                    poemSpl[i+1] = buf;
                }
            }
        }
        String poem2 = Poem.text;
        String[] poem2Spl = poem2.split("\n"); //Формируем массив строк из поэмы
        int maxLength = poemSpl[poemSpl.length-1].length(); //Размер самой длинной строки

        for (int i = 0; i < poem2Spl.length; i++) {
            String[] poemString = poem2Spl[i].split(" "); //Сплитим каждую строку поэмы
            int countWord = poemString.length; //Количество слов в строке
            int stringLength = poem2Spl[i].length() - (countWord-1); //Длинна строки
            int deltaSpace = maxLength - stringLength; //Разница с максимально длинной строкой
            int portionSpace = deltaSpace / (countWord-1); //Количество пробелов для каждого слова
            int remainderPortionSpace = deltaSpace % (countWord-1); //Остаток от деления пробелов для слов
            StringBuilder tempString = new StringBuilder(); //Построитель строк
            StringBuilder sb = new StringBuilder(); //Построитель строк
            int additionalSpace; //Дополнительный пробел
            for (int j = 1; j < countWord; j++) {
                if (remainderPortionSpace > 0) {
                    additionalSpace = 1;
                } else { additionalSpace = 0; }
                String spaceZero = " ";
                String space = " ";
                for (int k = 1; k < portionSpace+additionalSpace; k++) {
                    space = spaceZero + space;
                }
                sb = tempString.append(space).append(poemString[j]);
                remainderPortionSpace--;
            }
            System.out.println(poemString[0] + sb.toString());
        }


    }


}
