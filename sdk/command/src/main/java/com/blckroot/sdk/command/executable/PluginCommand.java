package com.blckroot.sdk.command.executable;

public class PluginCommand extends CallableCommandDecorator {
    private final String configurationFileDirectory;

    public PluginCommand(CallableCommand callableCommand, String configurationFileDirectory) {
        super(callableCommand);
        this.configurationFileDirectory = configurationFileDirectory;
    }

    public String getConfigurationFileDirectory() {
        return configurationFileDirectory;
    }
}
