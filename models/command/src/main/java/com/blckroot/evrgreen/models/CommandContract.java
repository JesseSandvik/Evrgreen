package com.blckroot.evrgreen.models;

import java.util.List;

interface CommandContract {
    String getName();
    String getVersion();
    String getSynopsis();
    String getDescription();
    List<PositionalParameter> getPositionalParameters();
    List<Option> getOptions();
    List<Command> getSubcommands();
}
