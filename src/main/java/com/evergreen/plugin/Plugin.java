package com.evergreen.plugin;

import java.io.File;

public class Plugin implements PluginContract {
    String pluginPath;
    public Plugin(String pluginPath) throws InvalidPluginException {
        StringBuilder invalidPluginMessage = new StringBuilder();
        invalidPluginMessage.append("An invalid plugin path has been provided: " + pluginPath);
    }
    public boolean pluginIsExecutable(String pluginPath) {
        File plugin = new File(pluginPath);
        return plugin.canExecute();
    }
    public boolean pluginExists(String pluginPath) {
        File plugin = new File(pluginPath);
        return plugin.exists();
    }
    public String getPluginPath() {
        return pluginPath;
    }
    public void setPluginPath(String pluginPath) {
        this.pluginPath = pluginPath;
    }
    @Override
    public void execute() {}
}
