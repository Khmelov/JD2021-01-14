package by.it.voitenkov.jd01_14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {
        File separator = new File(String.join(File.separator,
                "src", "by", "it", "voitenkov", "jd01_14", "TaskB.txt"));

        try (FileInputStream fileInputStream = new FileInputStream(separator)) {
            byte[] bytes = new byte[fileInputStream.available()];
            int counter = 0;
            byte currentByte;
            while ((currentByte = (byte) fileInputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String stringValue = new String(bytes);
            result(stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void result(String str) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("words", 0);
        result.put("marks", 0);
        Pattern pattern = Pattern.compile("([А-яЁё]+)|([,.!?:-]+)");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String read = matcher.group();
            if (read.matches("([А-яЁё]+)")) {
                result.replace("words", result.get("words") + 1);
            } else {
                result.replace("marks", result.get("marks") + 1);
            }
        }
        fileWriter(result);
    }

    static void fileWriter(HashMap<String, Integer> result) {
        File file = Path.of("src", "by", "it", "voitenkov", "jd01_14", "resultTaskB.txt").toFile();

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            Set<Map.Entry<String, Integer>> entries = result.entrySet();
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            for (Map.Entry<String, Integer> entry : entries) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
                if (count != entries.size()) {
                    count++;
                    stringBuilder.append(", ");
                }
            }
            System.out.println(stringBuilder);
            outputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}