package com.blckroot.sdk.command.callable;

import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;

import java.util.List;

public interface FrameworkBaseCommand {
    String getName();
    String getVersion();
    void setVersion(String version);
    String getSynopsis();
    void setSynopsis(String synopsis);
    String getDescription();
    void setDescription(String description);
    boolean isExecutesWithoutArguments();
    void setExecutesWithoutArguments(boolean executesWithoutArguments);
    PositionalParameter[] getPositionalParameters();
    void setPositionalParameters(PositionalParameter[] positionalParameters);
    Option[] getOptions();
    void setOptions(Option[] options);
    List<FrameworkCommand> getFrameworkSubcommands();
    void addFrameworkSubcommand(FrameworkCommand subcommand);
    List<String> getArguments();
    void addArgument(String argument);
    Integer call() throws Exception;
}
