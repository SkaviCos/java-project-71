package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String pathFile1, String pathFile2, String format) throws Exception {
        String data1 = getData(pathFile1);
        String data2 = getData(pathFile2);

        String fileType1 = getFType(pathFile1);
        String fileType2 = getFType(pathFile2);

        Map<String, Object> map1 = Parser.parse(data1, fileType1);
        Map<String, Object> map2 = Parser.parse(data2, fileType2);

        List<Map<String, Object>> result = DifferenceGenerator.generate(map1, map2);

        return Formatter.formatStyle(result, format);
    }

    public static String generate(String pathfile1, String pathfile2) throws Exception {
        return generate(pathfile1, pathfile2, "stylish");
    }

    public static String getData(String filepath) throws Exception {
        Path path = Paths.get(filepath.substring(filepath.indexOf("src")));
        return Files.readString(path);
    }

    public static String getFType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }
}
