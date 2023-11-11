package com.blckroot.sdk.command.framework.plugin;

import com.blckroot.sdk.file.system.validator.FileValidator;

public class PluginCommandBuilder {
    private final CallableCommandContract callableCommand;
    private final FileValidator fileValidator;
    private String executableFilePath;
    private String configurationFilePath;

    public PluginCommandBuilder(CallableCommandContract callableCommand) {
        this.callableCommand = callableCommand;
        this.fileValidator = new FileValidator();
    }

    public PluginCommandBuilder executableFileDirectory(String executableFileDirectory) {
        return this;
    }

//    public PluginCommandBuilder configurationFileDirectory(String configurationFileDirectory) {
//        this.configurationFileDirectory = configurationFileDirectory;
//        return this;
//    }

//    public PluginCommand build() {
//        FileValidator fileValidator = new FileValidator();
//        if (!fileValidator.fileCanExecute(executableFilePath)) {
//            System.out.println("The provided plugin file is not executable: " + executableFilePath);
//            System.out.println("Please provide a valid executable file path for the command: " + getName());
//            return 1;
//        }
//
//        List<String> arguments = new ArrayList<>();
//        arguments.add(executableFilePath);
//
//        if (getPositionalParameters() != null && getPositionalParameters().length >= 1) {
//            for (PositionalParameter positionalParameter : getPositionalParameters()) {
//                if (positionalParameter.getValue() != null) {
//                    arguments.add(positionalParameter.getValue().toString());
//                }
//            }
//        }
//
//        if (getOptions() != null && getOptions().length >= 1) {
//            for (Option option : getOptions()) {
//                if (option.getValue() != null) {
//                    arguments.add(option.getLongName());
//
//                    if (option.getLabel() != null) {
//                        arguments.add(option.getValue().toString());
//                    }
//                }
//            }
//        }
//
//        return pluginCommand;
//    }
}
