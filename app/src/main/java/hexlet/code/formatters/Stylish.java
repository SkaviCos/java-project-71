package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> differences) throws Exception {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> diffs : differences) {
            switch (diffs.get("status").toString()) {

                case "removed" -> result.append("  - ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("oldValue")).append("\n");
                case "added" -> result.append("  + ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("newValue")).append("\n");
                case "unchanged" -> result.append("    ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("oldValue")).append("\n");
                case "updated" -> {
                    result.append("  - ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("oldValue")).append("\n");
                    result.append("  + ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("newValue")).append("\n");
                }
                default -> throw new Exception("Invalid status");
            }

        }
        result.append("}");
        return result.toString();
    }
}
