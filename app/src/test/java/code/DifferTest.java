package code;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final String path1 = "src/test/resources/step81.json";
    private final String path2 = "src/test/resources/step82.json";
    private final String path3 = "src/test/resources/step81.yml";
    private final String path4 = "src/test/resources/step82.yml";

    private final Path pathStylish =
            Paths.get("src/test/resources/expected/testStylish").toAbsolutePath().normalize();
    private final Path pathPlain =
            Paths.get("src/test/resources/expected/testPlain").toAbsolutePath().normalize();
    private final Path pathJson =
            Paths.get("src/test/resources/expected/testJson").toAbsolutePath().normalize();

    @Test
    public void testJsonStyleStylish() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path1, path2, "stylish"));
    }

    @Test
    public void testYamlStyleStylish() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path3, path4, "stylish"));
    }

    @Test
    public void testJsonStylePlain() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path1, path2, "plain"));
    }

    @Test
    public void testYamlStylePlain() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path3, path4, "plain"));
    }

    @Test
    public void testJsonStyleJson() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path1, path2, "json"));
    }

    @Test
    public void testYamlStyleJson() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path3, path4, "json"));
    }


}
