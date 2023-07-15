package com.evergreen.plugin;

public class Plugin {
    String pluginPath;

    public Plugin(String pluginPath) {
        this.pluginPath = pluginPath;
    }

    public String getPluginPath() {
        return pluginPath;
    }

    public void setPluginPath(String pluginPath) {
        this.pluginPath = pluginPath;
    }
}
