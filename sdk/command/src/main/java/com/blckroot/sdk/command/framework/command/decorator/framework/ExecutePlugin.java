package com.blckroot.sdk.command.framework.command.decorator.framework;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.FrameworkCommandDecorator;
import com.blckroot.sdk.file.system.executor.FileExecutor;
import com.blckroot.sdk.file.system.validator.FileValidator;

import static java.lang.System.Logger.Level.*;

public class ExecutePlugin extends FrameworkCommandDecorator {
    private static final System.Logger LOGGER = System.getLogger(ExecutePlugin.class.getName());

    public ExecutePlugin(FrameworkBaseCommand frameworkCommand) {
        super(frameworkCommand);
        LOGGER.log(TRACE, ExecutePlugin.class.getName());
    }

    private void setArguments() {
        LOGGER.log(DEBUG, "setting arguments for framework command: " + super.getName());

        final String EXECUTABLE_FILE_DIRECTORY_KEY = "executable.directory";
        if(super.getProperties().getProperty(EXECUTABLE_FILE_DIRECTORY_KEY) == null) {
            LOGGER.log(ERROR,
                    "no executable.directory defined in framework command properties for framework command: " +
                            frameworkCommand.getName());
            return;
        }

        String executableFilePath = super.getProperties().getProperty(EXECUTABLE_FILE_DIRECTORY_KEY) + super.getName();
        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.fileCanExecute(executableFilePath)) {
            LOGGER.log(ERROR, "defined executable file cannot execute: " + frameworkCommand.getName());
//            TODO: improve handling behavior
            return;
        }

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            LOGGER.log(DEBUG, "windows operating system detected.");
            String bashExecutablePath = "C:\\Program Files\\Git\\bin\\bash.exe";
            String shExecutablePath= "C:\\Program Files\\Git\\bin\\sh.exe";
            if (fileValidator.fileExists(bashExecutablePath) &&
                    fileValidator.fileCanExecute(bashExecutablePath)) {
                LOGGER.log(DEBUG, "adding bash executable path as argument for windows: " + bashExecutablePath);
                super.addArgument(bashExecutablePath);
            } else if (fileValidator.fileExists(shExecutablePath) &&
                    fileValidator.fileCanExecute(shExecutablePath)) {
                LOGGER.log(DEBUG, "adding sh executable path as argument for windows: " + shExecutablePath);
                super.addArgument(shExecutablePath);
            }
        }

        LOGGER.log(DEBUG, "adding executable file path as argument: " + executableFilePath);
        super.addArgument(executableFilePath);

        if (!super.getPositionalParameters().isEmpty()) {
            LOGGER.log(DEBUG, "positional parameters detected for framework command: " + super.getName());
            super.getPositionalParameters().forEach(positionalParameter -> {
                if (positionalParameter.getValue() != null) {
                    LOGGER.log(DEBUG, "adding positional parameter value as argument: " + positionalParameter.getValue());
                    super.addArgument(positionalParameter.getValue().toString());
                }
            });
        }

        if (!super.getOptions().isEmpty()) {
            LOGGER.log(DEBUG, "options detected for framework command: " + super.getName());
            super.getOptions().forEach(option -> {
                if (option.getValue() != null) {
                    LOGGER.log(DEBUG, "adding option long name as argument: " + option.getLongName());
                    super.addArgument(option.getLongName());
                    if (option.getLabel() != null) {
                        LOGGER.log(DEBUG, "adding option value as argument: " + option.getValue());
                        super.addArgument(option.getValue().toString());
                    }
                }
            });
        }
    }

    @Override
    public Integer call() throws Exception {
        LOGGER.log(TRACE, "execute call method: " + ExecutePlugin.class.getName());
        setArguments();
        FileExecutor fileExecutor = new FileExecutor();
        fileExecutor.executeProgramWithOutput(super.getArguments(), System.out);
        return super.call();
    }
}
