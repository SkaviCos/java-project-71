package hexlet.code.formatters;

public enum Formats {

    JSON("json"),
    PLAIN("plain"),
    STYLISH("stylish");
    private final String value;

    Formats(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
