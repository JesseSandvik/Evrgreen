package com.blckroot.sdk.command.callable;

import com.blckroot.sdk.file.system.service.FileSystemService;
import com.blckroot.sdk.file.system.validator.FileValidator;

import java.util.Properties;

public class LoadPropertiesAtRuntime extends FrameworkCommandDecorator {
    private final String propertiesFileDirectory;

    public LoadPropertiesAtRuntime(FrameworkBaseCommand frameworkCommand, String propertiesFileDirectory) {
        super(frameworkCommand);
        this.propertiesFileDirectory = propertiesFileDirectory;
    }

    private void buildProperties() {
        String propertiesFilePath =
                propertiesFileDirectory + super.frameworkCommand.getName() + ".properties";

        System.out.println(propertiesFilePath);

        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.fileExists(propertiesFilePath)) {
            System.out.println("This triggered");
            return;
        }

        FileSystemService fileSystemService = new FileSystemService();
        Properties properties = fileSystemService.getPropertiesFromFile(propertiesFilePath);

        if (properties == null || properties.isEmpty()) {
            return;
        }

        final String VERSION_PROPERTY_KEY = "version";
        final String SYNOPSIS_PROPERTY_KEY = "synopsis";
        final String DESCRIPTION_PROPERTY_KEY = "description";
        final String EXECUTES_WITHOUT_ARGUMENTS_PROPERTY_KEY = "executes.without.arguments";

        if (!properties.getProperty(VERSION_PROPERTY_KEY).isBlank()) {
            System.out.println("VERSION: " + properties.getProperty(VERSION_PROPERTY_KEY));
            this.frameworkCommand.setVersion(properties.getProperty(VERSION_PROPERTY_KEY));
        }

        if (!properties.getProperty(SYNOPSIS_PROPERTY_KEY).isBlank()) {
            this.frameworkCommand.setSynopsis(properties.getProperty(SYNOPSIS_PROPERTY_KEY));
        }

        if (!properties.getProperty(DESCRIPTION_PROPERTY_KEY).isBlank()) {
            this.frameworkCommand.setDescription(DESCRIPTION_PROPERTY_KEY);
        }

        if (!properties.getProperty(EXECUTES_WITHOUT_ARGUMENTS_PROPERTY_KEY).isBlank()) {
            this.frameworkCommand.setExecutesWithoutArguments(
                    Boolean.parseBoolean(properties.getProperty(EXECUTES_WITHOUT_ARGUMENTS_PROPERTY_KEY)));
        }
    }

    @Override
    public Integer call() throws Exception {
        buildProperties();
        System.out.println("[ SUCCESSFULLY LOADED PROPERTIES AT RUNTIME ]");
        return super.call();
    }
}
