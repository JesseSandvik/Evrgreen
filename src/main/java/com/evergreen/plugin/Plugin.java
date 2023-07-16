package com.evergreen.plugin;

import java.io.File;

public class Plugin implements PluginContract {
    String pluginPath;
    public Plugin(String pluginPath) throws InvalidPluginException {
        if (pluginExists(pluginPath) && pluginIsExecutable(pluginPath)) {
            this.pluginPath = pluginPath;
        } else {
            throw new InvalidPluginException("An invalid plugin has been provided: " + pluginPath);
        }
    }
    public boolean pluginIsExecutable(String pluginPath) {
        File plugin = new File(pluginPath);
        return plugin.canExecute();
    }
    public boolean pluginExists(String pluginPath) {
        File plugin = new File(pluginPath);
        return plugin.exists();
    }
    @Override
    public void execute() {}
}
