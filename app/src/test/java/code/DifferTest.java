package code;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.formatters.Formats.JSON;
import static hexlet.code.formatters.Formats.PLAIN;
import static hexlet.code.formatters.Formats.STYLISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static final String PATH_1 = "src/test/resources/dataJsonFirst.json";
    private static final String PATH_2 = "src/test/resources/dataJsonSecond.json";
    private static final String PATH_3 = "src/test/resources/dataYamlFirst.yml";
    private static final String PATH_4 = "src/test/resources/dataYamlSecond.yml";

    private static final String PATH_STYLISH = "src/test/resources/expected/testStylish";
    private static final String PATH_JSON = "src/test/resources/expected/testJson";
    private static final String PATH_PLAIN = "src/test/resources/expected/testPlain";

    private static Path normalize(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    //TODO сделать параметеризороваанные тесты
    @Test
    public void testDefaultFormat() throws Exception {
        String expected = Files.readString(normalize(PATH_STYLISH));
        assertEquals(expected, Differ.generate(PATH_1, PATH_2));
    }

    @Test
    public void testJsonStyleStylish() throws Exception {
        String expected = Files.readString(normalize(PATH_STYLISH));
        assertEquals(expected, Differ.generate(PATH_1, PATH_2, STYLISH.getValue()));
    }

    @Test
    public void testYamlStyleStylish() throws Exception {
        String expected = Files.readString(normalize(PATH_STYLISH));
        assertEquals(expected, Differ.generate(PATH_3, PATH_4, STYLISH.getValue()));
    }

    @Test
    public void testJsonStylePlain() throws Exception {
        String expected = Files.readString(normalize(PATH_PLAIN));
        assertEquals(expected, Differ.generate(PATH_1, PATH_2, PLAIN.getValue()));
    }

    @Test
    public void testYamlStylePlain() throws Exception {
        String expected = Files.readString(normalize(PATH_PLAIN));
        assertEquals(expected, Differ.generate(PATH_3, PATH_4, PLAIN.getValue()));
    }

    @Test
    public void testJsonStyleJson() throws Exception {
        String expected = Files.readString(normalize(PATH_JSON));
        assertEquals(expected, Differ.generate(PATH_1, PATH_2, JSON.getValue()));
    }

    @Test
    public void testYamlStyleJson() throws Exception {
        String expected = Files.readString(normalize(PATH_JSON));
        assertEquals(expected, Differ.generate(PATH_3, PATH_4, JSON.getValue()));
    }


}
