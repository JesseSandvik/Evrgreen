package com.evergreen.plugin;

import java.io.File;

public class Plugin implements PluginContract {
    String pluginPath;
    public Plugin(String pluginPath) {
        this.pluginPath = pluginPath;
    }
    public boolean isExecutable(String pluginPath) {
        File plugin = new File(pluginPath);
        return plugin.canExecute();
    }
    public boolean exists(String pluginPath) {
        File plugin = new File(pluginPath);
        return plugin.exists();
    }
    @Override
    public void execute() {}
}
