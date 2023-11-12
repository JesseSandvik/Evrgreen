package com.blckroot.sdk.command.framework.command;

import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;

import java.util.List;
import java.util.Properties;

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
    Properties getProperties();
    void setProperties(Properties properties);
    List<PositionalParameter> getPositionalParameters();
    void addPositionalParameter(PositionalParameter positionalParameter);
    List<Option> getOptions();
    void addOption(Option option);
    List<FrameworkCommand> getFrameworkSubcommands();
    void addFrameworkSubcommand(FrameworkCommand subcommand);
    List<String> getArguments();
    void addArgument(String argument);
    Integer call() throws Exception;
}
