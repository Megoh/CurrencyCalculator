package pl.dominikwolowicz.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class FileResourcesUtils {
    public static BufferedInputStream getFileFromResourceAsStream(String fileName) {
        InputStream inputStream = FileResourcesUtils
                .class
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        } else {
            return (BufferedInputStream) inputStream;
        }
    }
}
