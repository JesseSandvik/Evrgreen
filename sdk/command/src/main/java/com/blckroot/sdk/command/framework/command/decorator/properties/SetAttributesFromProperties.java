package com.blckroot.sdk.command.framework.command.decorator.properties;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.FrameworkCommand;
import com.blckroot.sdk.command.framework.command.decorator.FrameworkCommandDecorator;
import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;
import com.blckroot.sdk.file.system.service.FileSystemService;
import com.blckroot.sdk.file.system.validator.FileValidator;

import java.util.Properties;

public class SetAttributesFromProperties extends FrameworkCommandDecorator {
    private final String propertiesFileDirectory;

    public SetAttributesFromProperties(FrameworkBaseCommand frameworkCommand, String propertiesFileDirectory) {
        super(frameworkCommand);
        this.propertiesFileDirectory = propertiesFileDirectory;
    }

    private String getFormattedKey(Integer keyIndex, String key) {
        return keyIndex + "." + key;
    }

    private Boolean propertyIsValid(FrameworkBaseCommand frameworkBaseCommand, String key) {
        if (key == null || key.isBlank()) {
            return false;
        }
        return frameworkBaseCommand.getProperties().getProperty(key) != null;
    }

    private Boolean propertiesAreValid(Properties properties) {
        return properties != null && !properties.isEmpty();
    }

    private void setPositionalParameters(FrameworkBaseCommand frameworkBaseCommand, Integer positionalParameterCount) {
        int index = 1;
        while (index < positionalParameterCount) {
            final String POSITIONAL_PARAMETER_LABEL_KEY = getFormattedKey(index, "positional.parameter.label");
            final String POSITIONAL_PARAMETER_SYNOPSIS_kEY = getFormattedKey(index, "positional.parameter.synopsis");
            final String POSITIONAL_PARAMETER_VALUE_KEY = getFormattedKey(index, "positional.parameter.value");

            PositionalParameter positionalParameter = new PositionalParameter();
            if (propertyIsValid(frameworkBaseCommand, POSITIONAL_PARAMETER_LABEL_KEY)) {
                positionalParameter.setLabel(
                        frameworkBaseCommand.getProperties().getProperty(POSITIONAL_PARAMETER_LABEL_KEY));
            }

            if (propertyIsValid(frameworkBaseCommand, POSITIONAL_PARAMETER_SYNOPSIS_kEY)) {
                positionalParameter.setSynopsis(
                        frameworkBaseCommand.getProperties().getProperty(POSITIONAL_PARAMETER_SYNOPSIS_kEY));
            }

            if (propertyIsValid(frameworkBaseCommand, POSITIONAL_PARAMETER_VALUE_KEY)) {
                positionalParameter.setValue(
                        frameworkBaseCommand.getProperties().getProperty(POSITIONAL_PARAMETER_VALUE_KEY));
            }

            frameworkBaseCommand.addPositionalParameter(positionalParameter);
            index = index + 1;
        }
    }

    private void setOptions(FrameworkBaseCommand frameworkBaseCommand, Integer optionCount) {
        int index = 1;
        while (index < optionCount) {
            final String OPTION_LONG_NAME_KEY = getFormattedKey(index, "option.long.name");
            final String OPTION_SHORT_NAME_KEY = getFormattedKey(index, "option.short.name");
            final String OPTION_SYNOPSIS_KEY = getFormattedKey(index, "option.synopsis");
            final String OPTION_LABEL_KEY = getFormattedKey(index, "option.label");
            final String OPTION_VALUE_KEY = getFormattedKey(index, "option.value");

            Option option = new Option();
            if (propertyIsValid(frameworkBaseCommand, OPTION_LONG_NAME_KEY)) {
                option.setLongName(frameworkBaseCommand.getProperties().getProperty(OPTION_LONG_NAME_KEY));
            }

            if (propertyIsValid(frameworkBaseCommand, OPTION_SHORT_NAME_KEY)) {
                option.setShortName(frameworkBaseCommand.getProperties().getProperty(OPTION_SHORT_NAME_KEY));
            }

            if (propertyIsValid(frameworkBaseCommand, OPTION_SYNOPSIS_KEY)) {
                option.setSynopsis(frameworkBaseCommand.getProperties().getProperty(OPTION_SYNOPSIS_KEY));
            }

            if (propertyIsValid(frameworkBaseCommand, OPTION_LABEL_KEY)) {
                option.setLabel(frameworkBaseCommand.getProperties().getProperty(OPTION_LABEL_KEY));
            }

            if (propertyIsValid(frameworkBaseCommand, OPTION_VALUE_KEY)) {
                option.setValue(frameworkBaseCommand.getProperties().getProperty(OPTION_VALUE_KEY));
            }

            frameworkBaseCommand.addOption(option);
            index = index + 1;
        }
    }

    private void setSubcommands(FrameworkBaseCommand frameworkBaseCommand, String[] subcommandNames) {
        for (String subcommandName : subcommandNames) {
            FrameworkBaseCommand subcommand =
                    new SetAttributesFromProperties(new FrameworkCommand(subcommandName), propertiesFileDirectory);
            setAttributes(subcommand);
            frameworkBaseCommand.addFrameworkSubcommand(subcommand);
        }
    }

    private void setAttributes(FrameworkBaseCommand frameworkBaseCommand) {
        String propertiesFilePath = propertiesFileDirectory + frameworkBaseCommand.getName() + ".properties";

        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.fileExists(propertiesFilePath)) {
//            TODO: improve handling behavior
            return;
        }

        FileSystemService fileSystemService = new FileSystemService();
        frameworkBaseCommand.setProperties(fileSystemService.getPropertiesFromFile(propertiesFilePath));

        if (!propertiesAreValid(frameworkBaseCommand.getProperties())) {
//            TODO: improve handling behavior
            return;
        }

        final String VERSION_PROPERTY_KEY = "version";
        final String SYNOPSIS_PROPERTY_KEY = "synopsis";
        final String DESCRIPTION_PROPERTY_KEY = "description";
        final String EXECUTES_WITHOUT_ARGUMENTS_KEY = "executes.without.arguments";
        final String POSITIONAL_PARAMETER_COUNT_PROPERTY_KEY = "positional.parameter.count";
        final String OPTION_COUNT_PROPERTY_KEY = "option.count";
        final String SUBCOMMANDS_PROPERTY_KEY = "subcommands";

        System.out.println("[ FRAMEWORK BASE COMMAND ]: " + frameworkBaseCommand.getName());

        if (propertyIsValid(frameworkBaseCommand, VERSION_PROPERTY_KEY)) {
            frameworkBaseCommand.setVersion(frameworkBaseCommand.getProperties().getProperty(VERSION_PROPERTY_KEY));
            System.out.println("[ FRAMEWORK BASE COMMAND VERSION ]: " + frameworkBaseCommand.getVersion());
        }

        if (propertyIsValid(frameworkBaseCommand, SYNOPSIS_PROPERTY_KEY)) {
            frameworkBaseCommand.setSynopsis(frameworkBaseCommand.getProperties().getProperty(SYNOPSIS_PROPERTY_KEY));
            System.out.println("[ FRAMEWORK BASE COMMAND SYNOPSIS ]: " + frameworkBaseCommand.getSynopsis());
        }

        if (propertyIsValid(frameworkBaseCommand, DESCRIPTION_PROPERTY_KEY)) {
            frameworkBaseCommand.setDescription
                    (frameworkBaseCommand.getProperties().getProperty(DESCRIPTION_PROPERTY_KEY));
            System.out.println("[ FRAMEWORK BASE COMMAND DESCRIPTION ]: " + frameworkBaseCommand.getDescription());
        }

        if (propertyIsValid(frameworkBaseCommand, EXECUTES_WITHOUT_ARGUMENTS_KEY)) {
            frameworkBaseCommand.setExecutesWithoutArguments(Boolean.parseBoolean(
                    frameworkBaseCommand.getProperties().getProperty(EXECUTES_WITHOUT_ARGUMENTS_KEY)));
            System.out.println("[ FRAMEWORK BASE COMMAND EXECUTES WITHOUT ARGUMENTS ]: " + frameworkBaseCommand.isExecutesWithoutArguments());
        }

        if (propertyIsValid(frameworkBaseCommand, POSITIONAL_PARAMETER_COUNT_PROPERTY_KEY)) {
            setPositionalParameters(frameworkBaseCommand, Integer.valueOf(
                    frameworkBaseCommand.getProperties().getProperty(POSITIONAL_PARAMETER_COUNT_PROPERTY_KEY)));
        }

        if (propertyIsValid(frameworkBaseCommand, OPTION_COUNT_PROPERTY_KEY)) {
            setOptions(frameworkBaseCommand, Integer.valueOf(
                    frameworkBaseCommand.getProperties().getProperty(OPTION_COUNT_PROPERTY_KEY)));
        }

        if (propertyIsValid(frameworkBaseCommand, SUBCOMMANDS_PROPERTY_KEY)) {
            setSubcommands(frameworkBaseCommand,
                    frameworkBaseCommand.getProperties().getProperty(SUBCOMMANDS_PROPERTY_KEY).split(","));
        }
    }

    @Override
    public Integer call() throws Exception {
        setAttributes(super.frameworkCommand);
        System.out.println("[ SUCCESSFULLY SET PROPERTIES AT RUNTIME ]");
        return super.call();
    }
}
