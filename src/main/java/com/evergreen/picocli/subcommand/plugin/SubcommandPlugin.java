package com.evergreen.picocli.subcommand.plugin;

import com.evergreen.picocli.subcommand.Subcommand;
import com.evergreen.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SubcommandPlugin extends Subcommand {
    private final Plugin plugin;
    public SubcommandPlugin(String name, Plugin plugin) {
        super(name);
        this.plugin = plugin;
    }
    public SubcommandPlugin(String name, String description, Plugin plugin) {
        super(name, description);
        this.plugin = plugin;
    }
    public SubcommandPlugin(String name, String description, List<String> parameters, Plugin plugin) {
        super(name, description, parameters);
        this.plugin = plugin;
    }
    public SubcommandPlugin(String name, String description, List<String> parameters, Map<Character, String> options, Plugin plugin) {
        super(name, description, parameters, options);
        this.plugin = plugin;
    }
    public boolean propertiesFileExists(String propertiesFilePath) {
        File propertiesFile = new File(propertiesFilePath);
        return propertiesFile.exists();
    }
    public boolean propertiesFileHasDescription(String propertiesFilePath) throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFilePath)) {
            Properties properties = new Properties();
            properties.load(input);

            return properties.getProperty("description") != null;
        } catch (IOException exception) {
            throw new IOException(exception.getMessage());
        }
    }
    public Plugin getPlugin() {
        return plugin;
    }
}
