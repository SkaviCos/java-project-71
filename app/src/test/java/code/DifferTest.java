package code;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.formatters.Formats.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static final String path1 = "src/test/resources/dataJsonFirst.json";
    private static final String path2 = "src/test/resources/dataJsonSecond.json";
    private static final String path3 = "src/test/resources/dataYamlFirst.yml";
    private static final String path4 = "src/test/resources/dataYamlSecond.yml";

    private static final String pathStylish = "src/test/resources/expected/testStylish";
    private static final String pathJson = "src/test/resources/expected/testJson";
    private static final String pathPlain = "src/test/resources/expected/testPlain";

    private static Path normalize(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    //TODO сделать параметеризороваанные тесты
    @Test
    public void testDefaultFormat() throws Exception {
        String expected = Files.readString(normalize(pathStylish));
        assertEquals(expected, Differ.generate(path1, path2));
    }
    @Test
    public void testJsonStyleStylish() throws Exception {
        String expected = Files.readString(normalize(pathStylish));
        assertEquals(expected, Differ.generate(path1, path2, STYLISH.getValue()));
    }

    @Test
    public void testYamlStyleStylish() throws Exception {
        String expected = Files.readString(normalize(pathStylish));
        assertEquals(expected, Differ.generate(path3, path4, STYLISH.getValue()));
    }

    @Test
    public void testJsonStylePlain() throws Exception {
        String expected = Files.readString(normalize(pathPlain));
        assertEquals(expected, Differ.generate(path1, path2, PLAIN.getValue()));
    }

    @Test
    public void testYamlStylePlain() throws Exception {
        String expected = Files.readString(normalize(pathPlain));
        assertEquals(expected, Differ.generate(path3, path4, PLAIN.getValue()));
    }

    @Test
    public void testJsonStyleJson() throws Exception {
        String expected = Files.readString(normalize(pathJson));
        assertEquals(expected, Differ.generate(path1, path2, JSON.getValue()));
    }

    @Test
    public void testYamlStyleJson() throws Exception {
        String expected = Files.readString(normalize(pathJson));
        assertEquals(expected, Differ.generate(path3, path4, JSON.getValue()));
    }


}
