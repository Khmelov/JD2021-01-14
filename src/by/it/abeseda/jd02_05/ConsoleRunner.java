package by.it.abeseda.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConsoleRunner {
    public static void main(String[] args) {
        // попробуем создать файл тіпа bat!чтобы все проісходіло автоматіческі!
        //выполненіе все по порядку как в командной строке
        //заходім в папку с данным файлом і запускаем его, все автоматізіровано

        String reference="by.it.abeseda.jd02_05.resourse.language";
        //ссылка на папку, где искать переводы
        //копіровані через точкі -команда copy Reference

        Locale locale=new Locale("be", "BY");
        ResourceBundle rb = ResourceBundle.getBundle(reference);
        rb.getString("");


    }
}
