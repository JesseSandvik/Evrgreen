package com.evergreen.plugin;

import java.io.File;

public class PluginFactory {
    public static PluginContract createPlugin(String executablePluginName, String executablePluginPath) throws InvalidPluginException {
        if (isValidPlugin(executablePluginPath)) {
            return new PluginSubcommand(executablePluginName, executablePluginPath);
        } else {
            throw new InvalidPluginException("Invalid Plugin: " + executablePluginPath);
        }
    }
    private static boolean isValidPlugin(String executablePluginPath) {
        File executablePlugin = new File(executablePluginPath);

        return executablePlugin.exists() && executablePlugin.canExecute();
    }
}
