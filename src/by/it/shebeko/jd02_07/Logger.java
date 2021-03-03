package by.it.shebeko.jd02_07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

enum Logger {
    GET;

    private static final String LOG_NAME = "log.txt";

    void log(String txt) throws CalcException {
        String filename = GetFileName.getFilename()+LOG_NAME;

        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true));) {
            out.println(txt+" Date, time: "+ LocalDateTime.now());
        } catch (IOException e) {
            throw new CalcException("ERROR: ", e);
        }
    }
}
