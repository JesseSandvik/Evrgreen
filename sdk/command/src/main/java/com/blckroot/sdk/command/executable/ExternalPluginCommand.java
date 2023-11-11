package com.blckroot.sdk.command.executable;

public class ExternalPluginCommand extends PluginCommand {
    private final String executableFileDirectory;
    public ExternalPluginCommand(
            CallableCommand executableCommand, String configurationFileDirectory, String executableFileDirectory) {
        super(executableCommand, configurationFileDirectory);
        this.executableFileDirectory = executableFileDirectory;
    }
}
