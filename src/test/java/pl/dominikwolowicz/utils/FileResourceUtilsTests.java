package pl.dominikwolowicz.utils;

import static pl.dominikwolowicz.utils.FileResourcesUtils.getFileFromResourceAsStream;

import org.junit.Test;
import static org.junit.Assert.assertThrows;


public class FileResourceUtilsTests {
    @Test
    public void testNonexistentFile() {
        assertThrows(IllegalArgumentException.class, () -> getFileFromResourceAsStream("nonexistent.file"));
    }
}
