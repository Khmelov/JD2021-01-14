package by.it.abeseda.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern pat=Pattern.compile("[а-яА-ЯёЁ]{4,}+");//pat это шаблон для поиска
//ищет все от а-я от А-Я и ёЁ,исключает слова длиной менее 4 символов
        Matcher matcher=pat.matcher(Poem.text);//дана ссылка на poem для поиска по шаблону pat
        while (matcher.find()) {//пока матчер ищет шаблон
            int start=matcher.start();// возвращает индекс первого символа
//            подпоследовательности, удовлетворяющей шаблону;
            sb.setCharAt(start+3,'#');//указывает индекс смвола и на что заменить
            if (matcher.group().length()>=7){//возвращает всю подпоследовательность,
//                удовлетворяющую шаблону;
                sb.setCharAt(start+6,'#');
            }
        }
        System.out.println(sb);
    }
}
