package com.blckroot.sdk.command.framework.command.decorator.framework;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.FrameworkCommandDecorator;
import com.blckroot.sdk.file.system.executor.FileExecutor;
import com.blckroot.sdk.file.system.validator.FileValidator;

public class ExecutePlugin extends FrameworkCommandDecorator {

    public ExecutePlugin(FrameworkBaseCommand frameworkCommand) {
        super(frameworkCommand);
    }

    private void setArguments() {
        final String EXECUTABLE_FILE_DIRECTORY_KEY = "executable.directory";
        if(super.getProperties().getProperty(EXECUTABLE_FILE_DIRECTORY_KEY) == null) {
            return;
        }

        String executableFilePath = super.getProperties().getProperty(EXECUTABLE_FILE_DIRECTORY_KEY) + super.getName();
        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.fileCanExecute(executableFilePath)) {
//            TODO: improve handling behavior
            return;
        }

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            String bashExecutablePath = "C:\\Program Files\\Git\\bin\\bash.exe";
            String shExecutablePath = "C:\\Program Files\\Git\\bin\\sh.exe";
            if (fileValidator.fileExists(bashExecutablePath) &&
                    fileValidator.fileCanExecute(bashExecutablePath)) {
                super.addArgument(bashExecutablePath);
            } else if (fileValidator.fileExists(shExecutablePath) &&
                    fileValidator.fileCanExecute(shExecutablePath)) {
                super.addArgument(shExecutablePath);
            }
        }

        super.addArgument(executableFilePath);

        if (!super.getPositionalParameters().isEmpty()) {
            super.getPositionalParameters().forEach(positionalParameter -> {
                if (positionalParameter.getValue() != null) {
                    super.addArgument(positionalParameter.getValue().toString());
                }
            });
        }

        if (!super.getOptions().isEmpty()) {
            super.getOptions().forEach(option -> {
                if (option.getValue() != null) {
                    super.addArgument(option.getLongName());
                    if (option.getLabel() != null) {
                        super.addArgument(option.getValue().toString());
                    }
                }
            });
        }
    }

    @Override
    public Integer call() throws Exception {
        setArguments();
        FileExecutor fileExecutor = new FileExecutor();
        System.out.println("[ ARGUMENTS ] > " + super.getArguments().toString());
        fileExecutor.executeProgramWithOutput(super.getArguments(), System.out);
        System.out.println("[ SUCCESSFULLY EXECUTED PROGRAM AT RUNTIME ]");
        return super.call();
    }
}
