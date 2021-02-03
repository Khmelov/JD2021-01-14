package by.it.petrov.JavaVocabulary;
import java.io.*;
public class FileOperator {

    static String workingDirectory = System.getProperty("user.dir")+"\\src\\by\\it\\petrov\\JavaVocabulary\\";

    public static String[] readFileIntoStringArray(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(workingDirectory + fileName));
        String line;
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString().split("\n");
    }

    public static Integer[] readFileIntoIntegerArray(String fileName) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(workingDirectory + fileName));
        String line;
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        String[] stringArray = sb.toString().split("\n");
        Integer[] integerArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            integerArray[i] = Integer.parseInt(stringArray[i]);
        }
        return integerArray;
    }

    public static void writePointsIntoFile(Integer[] pointsArray) throws IOException {
        StringBuilder strPoints = new StringBuilder();
        for (Integer integer : pointsArray) {
            strPoints.append(integer.toString()).append("\n");
        }
        FileWriter writer = new FileWriter(workingDirectory + "test.txt", false);
        writer.write(strPoints.toString());
        writer.flush();
        writer.close();
    }
}