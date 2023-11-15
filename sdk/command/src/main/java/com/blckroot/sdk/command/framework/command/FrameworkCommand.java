package com.blckroot.sdk.command.framework.command;

import com.blckroot.sdk.command.model.Command;
import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import static java.lang.System.Logger.Level.*;

public class FrameworkCommand extends Command implements FrameworkBaseCommand, Callable<Integer>  {
    private static final System.Logger LOGGER = System.getLogger(FrameworkCommand.class.getName());
    private Properties properties;
    private final List<PositionalParameter> positionalParameters = new ArrayList<>();
    private final List<Option> options = new ArrayList<>();
    private final List<FrameworkBaseCommand> frameworkSubcommands = new ArrayList<>();
    private final List<String> arguments = new ArrayList<>();

    public FrameworkCommand(String name) {
        super(name);
        LOGGER.log(TRACE, "created framework command instance: " + super.getName());
    }

    public Properties getProperties() {
        LOGGER.log(TRACE, "getting framework command properties: " + properties);
        return properties;
    }

    public void setProperties(Properties properties) {
        LOGGER.log(TRACE, "setting framework command properties: " + properties);
        this.properties = properties;
    }

    @Override
    public List<PositionalParameter> getPositionalParameters() {
        LOGGER.log(TRACE, "getting framework command positional parameters: " + positionalParameters);
        return positionalParameters;
    }

    public void addPositionalParameter(PositionalParameter positionalParameter) {
        LOGGER.log(TRACE, "adding framework command positional parameter: " + positionalParameter);
        this.positionalParameters.add(positionalParameter);
    }

    @Override
    public List<Option> getOptions() {
        LOGGER.log(TRACE, "getting framework command options: " + options);
        return options;
    }

    public void addOption(Option option) {
        LOGGER.log(TRACE, "adding framework command option: " + option);
        this.options.add(option);
    }

    @Override
    public List<FrameworkBaseCommand> getFrameworkSubcommands() {
        LOGGER.log(TRACE, "getting framework command subcommands: " + frameworkSubcommands);
        return frameworkSubcommands;
    }

    @Override
    public void addFrameworkSubcommand(FrameworkBaseCommand subcommand) {
        LOGGER.log(TRACE, "adding framework command subcommand: " + subcommand);
        frameworkSubcommands.add(subcommand);
    }

    @Override
    public List<String> getArguments() {
        LOGGER.log(TRACE, "getting framework command arguments: " + arguments);
        return arguments;
    }

    @Override
    public void addArgument(String argument) {
        LOGGER.log(TRACE, "adding framework command argument: " + argument);
        arguments.add(argument);
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
