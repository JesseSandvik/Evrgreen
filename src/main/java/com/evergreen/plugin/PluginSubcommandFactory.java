package com.evergreen.plugin;

import java.io.File;

public class PluginSubcommandFactory {
    public static PluginContract createPlugin(String pluginName, String pluginPath) throws InvalidPluginException {
        if (isValidPlugin(pluginPath)) {
            return new PluginSubcommand(pluginName, pluginPath);
        } else {
            throw new InvalidPluginException("Invalid Plugin: " + pluginName + " at " + pluginPath);
        }
    }
    private static boolean isValidPlugin(String pluginPath) {
        File executablePlugin = new File(pluginPath);

        return executablePlugin.exists() && executablePlugin.canExecute();
    }
}
