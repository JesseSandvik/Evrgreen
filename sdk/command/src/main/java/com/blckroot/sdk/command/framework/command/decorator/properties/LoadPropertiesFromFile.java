package com.blckroot.sdk.command.framework.command.decorator.properties;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.FrameworkCommandDecorator;
import com.blckroot.sdk.file.system.service.FileSystemService;
import com.blckroot.sdk.file.system.validator.FileValidator;

public class LoadPropertiesFromFile extends FrameworkCommandDecorator {
    private final String propertiesFileDirectory;

    public LoadPropertiesFromFile(FrameworkBaseCommand frameworkCommand, String propertiesFileDirectory) {
        super(frameworkCommand);
        this.propertiesFileDirectory = propertiesFileDirectory;
    }

    @Override
    public Integer call() throws Exception {
        String propertiesFilePath = propertiesFileDirectory + super.frameworkCommand.getName() + ".properties";

        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.fileExists(propertiesFilePath)) {
//            TODO: improve handling behavior
            return 1;
        }

        FileSystemService fileSystemService = new FileSystemService();
        this.frameworkCommand.setProperties(fileSystemService.getPropertiesFromFile(propertiesFilePath));

        System.out.println("[ SUCCESSFULLY LOADED PROPERTIES AT RUNTIME ]");
        return super.call();
    }
}
