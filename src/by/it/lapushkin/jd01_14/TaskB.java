package by.it.lapushkin.jd01_14;

import java.io.*;

public class TaskB {

    static final String FILENAME_TEXT = "TaskB.txt";
    static final String FILENAME_TXT_RESULT = "resultTaskB.txt";
    static final String MARKS_REG_EXP = "[!?,.;:]";
    static final String WORD_REG_EXP = "[а-яА-ЯёЁ]";
    static final String VOID_REG_EXP = " ";
    static final String TRANS_REG_RXP= "\n";

     public static String getPath(Class<?> cl) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    public static void main(String[] args) {
        int countWords = 0;
        int countMarks = 0;
        int lengthWord = 0;
        try (InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream(
                        getPath(TaskB.class)+FILENAME_TEXT));

             OutputStreamWriter outputStream = new OutputStreamWriter(
                     new FileOutputStream(
                             getPath(TaskB.class)+FILENAME_TXT_RESULT));
                ){
            while (inputStreamReader.ready()){
                char character = (char) inputStreamReader.read();
                String charToString =character+"";
                if (charToString.matches(MARKS_REG_EXP)){
                    countMarks++;
                }
                if(charToString.matches(WORD_REG_EXP)){
                    lengthWord++;
                }
                if(charToString.matches(VOID_REG_EXP) || charToString.matches(MARKS_REG_EXP) || charToString.matches(TRANS_REG_RXP)){
                    if(lengthWord != 0){
                        lengthWord = 0;
                        countWords++;
                    }
                }

            }
            String result = "words="+ countWords+", punctuation marks="+countMarks;
            System.out.println(result);
            outputStream.append(result);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e.getCause());
        }
    }

}
