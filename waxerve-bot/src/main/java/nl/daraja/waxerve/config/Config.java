package nl.daraja.waxerve.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Config {
    private final Properties props = new Properties();

    public Config(String path) throws IOException {
        try (var reader = Files.newBufferedReader(Path.of(path))) {
            props.load(reader);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
