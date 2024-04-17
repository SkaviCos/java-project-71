package code;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static hexlet.code.formatters.Formats.JSON;
import static hexlet.code.formatters.Formats.PLAIN;
import static hexlet.code.formatters.Formats.STYLISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static final String JSON_FIRST = "src/test/resources/dataJsonFirst.json";
    private static final String JSON_SECOND = "src/test/resources/dataJsonSecond.json";
    private static final String YAML_FIRST = "src/test/resources/dataYamlFirst.yml";
    private static final String YAML_SECOND = "src/test/resources/dataYamlSecond.yml";

    private static final String PATH_STYLISH = "src/test/resources/expected/testStylish";
    private static final String PATH_JSON = "src/test/resources/expected/testJson";
    private static final String PATH_PLAIN = "src/test/resources/expected/testPlain";

    private static Path normalize(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    private static Stream<Arguments> testStyle() {
        return Stream.of(
                Arguments.of(JSON_FIRST, JSON_SECOND, STYLISH.getValue(), PATH_STYLISH),
                Arguments.of(YAML_FIRST, YAML_SECOND, STYLISH.getValue(), PATH_STYLISH),
                Arguments.of(JSON_FIRST, JSON_SECOND, PLAIN.getValue(), PATH_PLAIN),
                Arguments.of(YAML_FIRST, YAML_SECOND, PLAIN.getValue(), PATH_PLAIN),
                Arguments.of(JSON_FIRST, JSON_SECOND, JSON.getValue(), PATH_JSON),
                Arguments.of(YAML_FIRST, YAML_SECOND, JSON.getValue(), PATH_JSON)
        );
    }

    @Test
    public void testDefaultFormat() throws Exception {
        String expected = Files.readString(normalize(PATH_STYLISH));
        assertEquals(expected, Differ.generate(JSON_FIRST, JSON_SECOND));
    }

    @ParameterizedTest(name = "{index} Style {2} test with files {0} and {1}")
    @MethodSource("testStyle")
    final void styleTest(String path1, String path2, String format, String expectedStyle) throws Exception {
        String expected = Files.readString(normalize(expectedStyle));
        assertEquals(expected, Differ.generate(path1, path2, format));
    }
}
