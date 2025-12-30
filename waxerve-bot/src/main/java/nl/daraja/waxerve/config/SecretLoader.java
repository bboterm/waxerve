package nl.daraja.waxerve.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SecretLoader {
    private static final String CONFIG_ENV_VAR = "SECRET_FILE_PATH";
    private static final String DEFAULT_SECRET_FILE = "/run/secrets/api_key";

    // Prevents accidental instantiation
    private SecretLoader() {}

    public static String loadApiKey() {
        // 1. Determine secret file path (configurable)
        String configuredPath = System.getenv(CONFIG_ENV_VAR);
        Path secretPath = Path.of(
                configuredPath != null && !configuredPath.isBlank()
                        ? configuredPath
                        : DEFAULT_SECRET_FILE
        );

        // 2. Try reading the secret file
        if (Files.exists(secretPath)) {
            try {
                return Files.readString(secretPath).trim();
            } catch (IOException e) {
                throw new RuntimeException("Failed to read secret file: " + secretPath, e);
            }
        }

        // 3. Fail clearly
        throw new IllegalStateException("API key not found in env var or secret file");
    }
}
