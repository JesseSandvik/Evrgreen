package com.blckroot.sdk.command.executable;

import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;
import com.blckroot.sdk.file.system.service.FileSystemService;
import com.blckroot.sdk.file.system.validator.FileValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PluginCommand extends CallableCommandDecorator {
    private final String configurationFileDirectory;

    public PluginCommand(CallableCommand executableCommand, String configurationFileDirectory) {
        super(executableCommand);
        this.configurationFileDirectory = configurationFileDirectory;
    }

    @Override
    public Integer call() {
        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.directoryExists(configurationFileDirectory)) {
            return 1;
        }

        String configurationFilePath =
                configurationFileDirectory + this.callableCommand.getName() + ".properties";
        if (!fileValidator.fileExists(configurationFilePath)) {
            return 1;
        }

        FileSystemService fileSystemService = new FileSystemService();
        Properties commandProperties = fileSystemService.getPropertiesFromFile(configurationFilePath);

        if (commandProperties == null || commandProperties.isEmpty()) {
            return 1;
        }

        setCommandProperties(commandProperties);
        return 0;
    }

    private void setCommandProperties(Properties properties) {
        final String VERSION_PROPERTY_KEY = "version";
        final String SYNOPSIS_PROPERTY_KEY = "synopsis";
        final String DESCRIPTION_PROPERTY_KEY = "description";
        final String EXECUTES_WITHOUT_ARGUMENTS_KEY = "executes.without.arguments";
        final String POSITIONAL_PARAMETER_COUNT_KEY = "positional.parameter.count";
        final String OPTION_COUNT_KEY="option.count";

        if (!properties.getProperty(VERSION_PROPERTY_KEY).isBlank()) {
            this.callableCommand.setVersion(properties.getProperty(VERSION_PROPERTY_KEY));
        }

        if (!properties.getProperty(SYNOPSIS_PROPERTY_KEY).isBlank()) {
            this.callableCommand.setSynopsis(properties.getProperty(SYNOPSIS_PROPERTY_KEY));
        }

        if (!properties.getProperty(DESCRIPTION_PROPERTY_KEY).isBlank()) {
            this.callableCommand.setDescription(properties.getProperty(DESCRIPTION_PROPERTY_KEY));
        }

        if (!properties.getProperty(EXECUTES_WITHOUT_ARGUMENTS_KEY).isBlank()) {
            this.callableCommand.setExecutesWithoutArguments(
                    Boolean.parseBoolean(properties.getProperty(EXECUTES_WITHOUT_ARGUMENTS_KEY)));
        }

        if (!properties.getProperty(POSITIONAL_PARAMETER_COUNT_KEY).isBlank()) {
            int positionalParameterCount = Integer.parseInt(properties.getProperty(POSITIONAL_PARAMETER_COUNT_KEY));
            setPositionalParametersFromProperties(positionalParameterCount, properties);
        }

        if (!properties.getProperty(OPTION_COUNT_KEY).isBlank()) {
            int optionCount = Integer.parseInt(properties.getProperty(OPTION_COUNT_KEY));
            setOptionsFromProperties(optionCount, properties);
        }
    }

    private void setPositionalParametersFromProperties(Integer positionalParameterCount, Properties properties) {
        int index = 1;

        List<PositionalParameter> positionalParameters = new ArrayList<>();
        while (index < positionalParameterCount) {
            String POSITIONAL_PARAMETER_LABEL_KEY = index + ".positional.parameter.label";
            String POSITIONAL_PARAMETER_DESCRIPTION_KEY = index + ".positional.parameter.synopsis";
            PositionalParameter positionalParameter = new PositionalParameter();

            if (properties.getProperty(POSITIONAL_PARAMETER_LABEL_KEY).isBlank()) {
                positionalParameter.setLabel(properties.getProperty(POSITIONAL_PARAMETER_LABEL_KEY));
            }

            if (properties.getProperty(POSITIONAL_PARAMETER_DESCRIPTION_KEY).isBlank()) {
                positionalParameter.setSynopsis(properties.getProperty(POSITIONAL_PARAMETER_DESCRIPTION_KEY));
            }

            positionalParameters.add(positionalParameter);
            index = index + 1;
        }
        this.callableCommand.setPositionalParameters(positionalParameters.toArray(new PositionalParameter[0]));
    }

    private void setOptionsFromProperties(Integer optionCount, Properties properties) {
        int index = 1;

        List<Option> options = new ArrayList<>();
        while (index < optionCount) {
            String OPTION_LONG_NAME_KEY = index + ".option.long.name";
            String OPTION_SHORT_NAME_KEY = index + ".option.short.name";
            String OPTION_SYNOPSIS_KEY = index + ".option.synopsis";
            String OPTION_LABEL_KEY = index + ".option.label";
            Option option = new Option();

            if (properties.getProperty(OPTION_LONG_NAME_KEY).isBlank()) {
                option.setLongName(properties.getProperty(OPTION_LONG_NAME_KEY));
            }

            if (properties.getProperty(OPTION_SHORT_NAME_KEY).isBlank()) {
                option.setShortName(properties.getProperty(OPTION_SHORT_NAME_KEY));
            }

            if (properties.getProperty(OPTION_SYNOPSIS_KEY).isBlank()) {
                option.setSynopsis(properties.getProperty(OPTION_SYNOPSIS_KEY));
            }

            if (properties.getProperty(OPTION_LABEL_KEY).isBlank()) {
                option.setLabel(OPTION_LABEL_KEY);
            }

            options.add(option);
            index = index + 1;
        }
        this.callableCommand.setOptions(options.toArray(new Option[0]));
    }
}
