package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String formatStyle(
            List<Map<String, Object>> differences, String format) throws Exception {
        switch (format) {
            case "stylish" -> {
                return Stylish.format(differences);
            }
            case "plain" -> {
                return Plain.format(differences);
            }
            case "json" -> {
                return Json.format(differences);
            }
            default -> throw new Exception("Invalid format");
        }
    }
}
