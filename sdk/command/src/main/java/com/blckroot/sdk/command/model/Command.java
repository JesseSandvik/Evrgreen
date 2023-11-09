package com.blckroot.evrgreen.models.command;

import com.blckroot.evrgreen.models.option.Option;
import com.blckroot.evrgreen.models.positionalParameter.PositionalParameter;

import java.util.ArrayList;
import java.util.List;


public class Command implements CommandContract {
    private final String name;
    private String version;
    private String synopsis;
    private String description;
    private final List<PositionalParameter> positionalParameters = new ArrayList<>();
    private final List<Option> options = new ArrayList<>();
    private final List<Command> subcommands = new ArrayList<>();

    public Command(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<PositionalParameter> getPositionalParameters() {
        return positionalParameters;
    }

    @Override
    public void addPositionalParameter(PositionalParameter positionalParameter) {
        positionalParameters.add(positionalParameter);
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public void addOption(Option option) {
        options.add(option);
    }

    @Override
    public List<Command> getSubcommands() {
        return subcommands;
    }

    @Override
    public void addSubcommand(Command subcommand) {
        subcommands.add(subcommand);
    }
}
