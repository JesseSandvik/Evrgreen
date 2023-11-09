package com.blckroot.sdk.command.model;


public class Command {
    private String name;
    private String version;
    private String synopsis;
    private String description;
    private PositionalParameter[] positionalParameters;
    private Option[] options;
    private Command[] subcommands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PositionalParameter[] getPositionalParameters() {
        return positionalParameters;
    }

    public void setPositionalParameters(PositionalParameter[] positionalParameters) {
        this.positionalParameters = positionalParameters;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    public Command[] getSubcommands() {
        return subcommands;
    }

    public void setSubcommands(Command[] subcommands) {
        this.subcommands = subcommands;
    }
}
