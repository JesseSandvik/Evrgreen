package com.blckroot.sdk.command.executable;

import com.blckroot.sdk.file.system.validator.FileValidator;

import java.util.Properties;

public class PluginCommand extends CallableCommandDecorator {
    private final String configurationFileDirectory;
    public PluginCommand(CallableCommand executableCommand, String configurationFileDirectory) {
        super(executableCommand);
        this.configurationFileDirectory = configurationFileDirectory;
    }

    @Override
    public Integer call() {
        try {
            FileValidator fileValidator = new FileValidator();

            if (!fileValidator.directoryExists(configurationFileDirectory)) {
                return 1;
            }

            String configurationFilePath =
                    configurationFileDirectory + this.callableCommand.getName() + ".properties";

            if (!fileValidator.fileExists(configurationFilePath)) {
                return 1;
            }
        }
    }
}
