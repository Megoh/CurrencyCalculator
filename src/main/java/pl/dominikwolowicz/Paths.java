package pl.dominikwolowicz;

public enum Paths {
    XPATH("//Cube/Cube/Cube"),
    FILENAME("eurofxref-daily.xml");

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getValue() {
        return path;
    }
}
