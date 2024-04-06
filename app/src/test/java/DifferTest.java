import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class DifferTest {

    @Test
    public void firstTest() {
        Differ differ = new Differ();

        var file = "app/src/test/resources/file1.json";
        var file2 = "/Users/skavicos/IdeaProjects/skaviCos/java-project-71/app/file2.json";



//        var generate = differ.generate(map1, map2);
    }

    //TODO плохая практика
    private Map<String, Object> getData(String filepath) throws IOException {
        Path path1 = Paths.get(filepath).toAbsolutePath();
        String json1 = Files.readString(path1);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1 = mapper.readValue(json1, Map.class);
        return map1;
    }

}
