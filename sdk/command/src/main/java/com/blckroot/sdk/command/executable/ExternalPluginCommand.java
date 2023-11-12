package com.blckroot.sdk.command.executable;

import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;
import com.blckroot.sdk.file.system.validator.FileValidator;
import com.blckroot.sdk.operating.system.service.OperatingSystemService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExternalPluginCommand extends PluginCommand {
    private final String executableFileDirectory;

    public ExternalPluginCommand(
            CallableCommand executableCommand, String configurationFileDirectory, String executableFileDirectory) {
        super(executableCommand, configurationFileDirectory);
        this.executableFileDirectory = executableFileDirectory;
    }

    public String getExecutableFileDirectory() {
        return executableFileDirectory;
    }

    private String getExecutableFilePath(String executableFileName) {
        FileValidator fileValidator = new FileValidator();
        OperatingSystemService operatingSystemService = new OperatingSystemService();
        String executableFilePath =
                executableFileDirectory + operatingSystemService.getFileSeparator() + executableFileName;

        if (!fileValidator.fileExists(executableFilePath) || !fileValidator.fileCanExecute(executableFilePath)) {
            return null;
        }
        return executableFilePath;
    }

    @Override
    public Integer call() {
        String executableFilePath = getExecutableFilePath(this.callableCommand.getName());
        if (executableFilePath == null) {
            return 1;
        }

        List<String> arguments = new ArrayList<>();
        arguments.add(executableFilePath);

        if (this.callableCommand.getPositionalParameters() != null) {
            for (PositionalParameter positionalParameter : this.callableCommand.getPositionalParameters()) {
                if (positionalParameter.getValue() != null) {
                    arguments.add(positionalParameter.getValue().toString());
                }
            }
        }

        if (this.callableCommand.getOptions() != null) {
            for (Option option : this.callableCommand.getOptions()) {
                if (option.getValue() != null) {
                    arguments.add(option.getLongName());
                    if (option.getLabel() != null) {
                        arguments.add(option.getValue().toString());
                    }
                }
            }
        }

        return executeExternalFile(arguments);
    }

    private Integer executeExternalFile(List<String> arguments) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(arguments);
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            return process.exitValue();

        } catch (RuntimeException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
