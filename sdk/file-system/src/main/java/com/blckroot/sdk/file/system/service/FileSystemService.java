package com.blckroot.sdk.file.system.service;

import java.util.Properties;

public class FileSystemService implements FileSystemServiceContract {
    private final FileSystemServiceUtility fileSystemServiceUtility;

    public FileSystemService() {
        this.fileSystemServiceUtility = new FileSystemServiceUtility();
    }

    @Override
    public Properties getPropertiesFromFile(String propertiesFile) {
        return fileSystemServiceUtility.getPropertiesFromFile(propertiesFile);
    }
}
