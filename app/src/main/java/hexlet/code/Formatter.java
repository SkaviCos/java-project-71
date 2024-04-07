package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String formatStyle(
            List<Map<String, Object>> differences, String format) throws IOException {
        if (format.equals("stylish")) {
            return Stylish.format(differences);
        } else if (format.equals("plain")) {
            return Plain.format(differences);
        } else {
            System.out.println("Format" + format + "is not correct!");
        }
        return Stylish.format(differences);
    }
}
