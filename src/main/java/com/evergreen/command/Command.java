package com.evergreen.command;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private final String name;
    private String version;
    private String usageDescriptionSynopsis;
    private String usageDescriptionFull;
    private final List<PositionalParameter> positionalParameters = new ArrayList<>();
    private final List<Option> options = new ArrayList<>();
    private final List<Command> subcommands = new ArrayList<>();

    public Command(String name) {
        this.name = name;
    }

    public Command(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getUsageDescriptionSynopsis() {
        return usageDescriptionSynopsis;
    }

    public String getUsageDescriptionFull() {
        return usageDescriptionFull;
    }

    public List<PositionalParameter> getPositionalParameters() {
        return positionalParameters;
    }

    public List<Option> getOptions() {
        return options;
    }

    public List<Command> getSubcommands() {
        return subcommands;
    }

    public void setUsageDescriptionSynopsis(String usageDescriptionSynopsis) {
        this.usageDescriptionSynopsis = usageDescriptionSynopsis;
    }

    public void setUsageDescriptionFull(String usageDescriptionFull) {
        this.usageDescriptionFull = usageDescriptionFull;
    }
}
