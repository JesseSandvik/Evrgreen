package com.blckroot.sdk.command.framework;

import com.blckroot.sdk.command.framework.plugin.PluginCommand;
import com.blckroot.sdk.command.framework.service.CommandService;

public class Something {
    private final PluginCommand pluginCommand;

    public Something(PluginCommand pluginCommand) {
        this.pluginCommand = pluginCommand;
    }

    public Integer execute(String[] arguments) {
        String executableFileDirectory = "";
        String configurationFileDirectory = "";

        CommandService commandService = new CommandService(pluginCommand);
        return commandService.parse(arguments);
    }
}
