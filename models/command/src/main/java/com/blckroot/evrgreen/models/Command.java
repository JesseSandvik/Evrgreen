package com.blckroot.evrgreen.models;

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
    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<PositionalParameter> getPositionalParameters() {
        return positionalParameters;
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public List<Command> getSubcommands() {
        return subcommands;
    }
}
