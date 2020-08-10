package online.rumac.main.view.dataInput.fromFile;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class LineReader {

    public static List<String> getLines(String filePath) {

        try (
                BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            ) {

            String line;
            List<String> lines = new LinkedList<>();

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
