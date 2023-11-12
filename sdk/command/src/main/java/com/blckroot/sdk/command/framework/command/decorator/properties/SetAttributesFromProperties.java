package com.blckroot.sdk.command.framework.command.decorator.properties;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.FrameworkCommandDecorator;
import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;

public class SetAttributesFromProperties extends FrameworkCommandDecorator {

    public SetAttributesFromProperties(FrameworkBaseCommand frameworkCommand) {
        super(frameworkCommand);
    }

    private String getFormattedKey(Integer keyIndex, String key) {
        return keyIndex + "." + key;
    }

    private Boolean propertyIsValid(String key) {
        return this.frameworkCommand.getProperties().getProperty(key) != null;
    }

    private void setPositionalParameters(Integer positionalParameterCount) {
        int index = 1;
        while (index < positionalParameterCount) {
            final String POSITIONAL_PARAMETER_LABEL_KEY = getFormattedKey(index, "positional.parameter.label");
            final String POSITIONAL_PARAMETER_SYNOPSIS_kEY = getFormattedKey(index, "positional.parameter.synopsis");
            final String POSITIONAL_PARAMETER_VALUE_KEY = getFormattedKey(index, "positional.parameter.value");

            PositionalParameter positionalParameter = new PositionalParameter();
            if (propertyIsValid(POSITIONAL_PARAMETER_LABEL_KEY)) {
                positionalParameter.setLabel(
                        this.frameworkCommand.getProperties().getProperty(POSITIONAL_PARAMETER_LABEL_KEY));
            }

            if (propertyIsValid(POSITIONAL_PARAMETER_SYNOPSIS_kEY)) {
                positionalParameter.setSynopsis(
                        this.frameworkCommand.getProperties().getProperty(POSITIONAL_PARAMETER_SYNOPSIS_kEY));
            }

            if (propertyIsValid(POSITIONAL_PARAMETER_VALUE_KEY)) {
                positionalParameter.setValue(
                        this.frameworkCommand.getProperties().getProperty(POSITIONAL_PARAMETER_VALUE_KEY));
            }

            this.frameworkCommand.addPositionalParameter(positionalParameter);
            index = index + 1;
        }
    }

    private void setOptions(Integer optionCount) {
        int index = 1;
        while (index < optionCount) {
            final String OPTION_LONG_NAME_KEY = getFormattedKey(index, "option.long.name");
            final String OPTION_SHORT_NAME_KEY = getFormattedKey(index, "option.short.name");
            final String OPTION_SYNOPSIS_KEY = getFormattedKey(index, "option.synopsis");
            final String OPTION_LABEL_KEY = getFormattedKey(index, "option.label");
            final String OPTION_VALUE_KEY = getFormattedKey(index, "option.value");

            Option option = new Option();
            if (propertyIsValid(OPTION_LONG_NAME_KEY)) {
                option.setLongName(this.frameworkCommand.getProperties().getProperty(OPTION_LONG_NAME_KEY));
            }

            if (propertyIsValid(OPTION_SHORT_NAME_KEY)) {
                option.setShortName(this.frameworkCommand.getProperties().getProperty(OPTION_SHORT_NAME_KEY));
            }

            if (propertyIsValid(OPTION_SYNOPSIS_KEY)) {
                option.setSynopsis(this.frameworkCommand.getProperties().getProperty(OPTION_SYNOPSIS_KEY));
            }

            if (propertyIsValid(OPTION_LABEL_KEY)) {
                option.setLabel(this.frameworkCommand.getProperties().getProperty(OPTION_LABEL_KEY));
            }

            if (propertyIsValid(OPTION_VALUE_KEY)) {
                option.setValue(this.frameworkCommand.getProperties().getProperty(OPTION_VALUE_KEY));
            }

            this.frameworkCommand.addOption(option);
            index = index + 1;
        }
    }

    private void setAttributes() {
        final String VERSION_PROPERTY_KEY = "version";
        final String SYNOPSIS_PROPERTY_KEY = "synopsis";
        final String DESCRIPTION_PROPERTY_KEY = "description";
        final String EXECUTES_WITHOUT_ARGUMENTS_KEY = "executes.without.arguments";
        final String POSITIONAL_PARAMETER_COUNT_PROPERTY_KEY = "positional.parameter.count";
        final String OPTION_COUNT_PROPERTY_KEY = "option.count";

        if (propertyIsValid(VERSION_PROPERTY_KEY)) {
            this.frameworkCommand.setVersion(
                    this.frameworkCommand.getProperties().getProperty(VERSION_PROPERTY_KEY));
        }

        if (propertyIsValid(SYNOPSIS_PROPERTY_KEY)) {
            this.frameworkCommand.setSynopsis(
                    this.frameworkCommand.getProperties().getProperty(SYNOPSIS_PROPERTY_KEY));
        }

        if (propertyIsValid(DESCRIPTION_PROPERTY_KEY)) {
            this.frameworkCommand.setDescription
                    (this.frameworkCommand.getProperties().getProperty(DESCRIPTION_PROPERTY_KEY));
        }

        if (propertyIsValid(EXECUTES_WITHOUT_ARGUMENTS_KEY)) {
            this.frameworkCommand.setExecutesWithoutArguments(Boolean.parseBoolean(
                    this.frameworkCommand.getProperties().getProperty(EXECUTES_WITHOUT_ARGUMENTS_KEY)));
        }

        if (propertyIsValid(POSITIONAL_PARAMETER_COUNT_PROPERTY_KEY)) {
            setPositionalParameters(Integer.valueOf(
                    this.frameworkCommand.getProperties().getProperty(POSITIONAL_PARAMETER_COUNT_PROPERTY_KEY)));
        }

        if (propertyIsValid(OPTION_COUNT_PROPERTY_KEY)) {
            setOptions(Integer.valueOf(
                    this.frameworkCommand.getProperties().getProperty(OPTION_COUNT_PROPERTY_KEY)));
        }
    }

    @Override
    public Integer call() throws Exception {
        if (this.frameworkCommand.getProperties() == null || this.frameworkCommand.getProperties().isEmpty()) {
//            TODO: improve handling behavior
            return 1;
        }
        setAttributes();
        System.out.println("[ SUCCESSFULLY SET PROPERTIES AT RUNTIME ]");
        return super.call();
    }
}
