package com.blckroot.sdk.file.system.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class FileSystemServiceUtility implements FileSystemServiceContract {

    @Override
    public Properties getPropertiesFromFile(String propertiesFile) {
        try (InputStream inputStream = new FileInputStream(propertiesFile)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
