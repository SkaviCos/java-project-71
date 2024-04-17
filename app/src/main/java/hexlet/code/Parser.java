package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String fileType) throws Exception {
        ObjectMapper objectmapper = chooseFileType(fileType);
        return objectmapper.readValue(data, new TypeReference<>() {
        });
    }

    private static ObjectMapper chooseFileType(String fileType) throws Exception {
        switch (fileType) {
            case "json" -> {
                return new ObjectMapper();
            }
            case "yaml", "yml" -> {
                return new ObjectMapper(new YAMLFactory());
            }
            default -> throw new Exception("Invalid file type");
        }
    }

}
