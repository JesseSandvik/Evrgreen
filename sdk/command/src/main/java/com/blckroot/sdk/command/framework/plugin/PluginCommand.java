package com.blckroot.sdk.command.framework.plugin;

import com.blckroot.sdk.command.executable.CallableCommand;
import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;
import com.blckroot.sdk.file.system.validator.FileValidator;

import java.util.ArrayList;
import java.util.List;

public class PluginCommand extends CallableCommand {
    private final String executableFilePath;

    public PluginCommand(String name, String executableFilePath) {
        super(name);
        this.executableFilePath = executableFilePath;
    }

    public String getExecutableFilePath() {
        return executableFilePath;
    }

    @Override
    public Integer call() {
        try {
            FileValidator fileValidator = new FileValidator();
            if (!fileValidator.fileCanExecute(executableFilePath)) {
                System.out.println("The provided plugin file is not executable: " + executableFilePath);
                System.out.println("Please provide a valid executable file path for the command: " + getName());
                return 1;
            }

            List<String> arguments = new ArrayList<>();
            arguments.add(executableFilePath);

            if (getPositionalParameters() != null && getPositionalParameters().length >= 1) {
                for (PositionalParameter positionalParameter : getPositionalParameters()) {
                    if (positionalParameter.getValue() != null) {
                        arguments.add(positionalParameter.getValue().toString());
                    }
                }
            }

            if (getOptions() != null && getOptions().length >= 1) {
                for (Option option : getOptions()) {
                    if (option.getValue() != null) {
                        arguments.add(option.getLongName());

                        if (option.getLabel() != null) {
                            arguments.add(option.getValue().toString());
                        }
                    }
                }
            }



            return 0;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
