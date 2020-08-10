package online.rumac.main.view.game.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FromFile {

    private FromFile() {}

    public static List<String> buildLines(String path) {
        File file = new File(path);
        return getLinesFrom(file);
    }

    private static List<String> getLinesFrom(File file) {

        try (
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader)
            )   {
            List<String> lines = new LinkedList<>();
            String singleLine;
            while ((singleLine = bufferedReader.readLine()) != null) {
                lines.add(singleLine);
            }

            return lines;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
