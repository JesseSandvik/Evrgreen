package com.blckroot.evrgreen.models;

import java.util.List;

interface CommandContract {
    String getName();
    String getVersion();
    void setVersion(String version);
    String getSynopsis();
    void setSynopsis(String synopsis);
    String getDescription();
    void setDescription(String description);
    List<PositionalParameter> getPositionalParameters();
    void addPositionalParameter(PositionalParameter positionalParameter);
    List<Option> getOptions();
    void addOption(Option option);
    List<Command> getSubcommands();
    void addSubcommand(Command subcommand);
}
