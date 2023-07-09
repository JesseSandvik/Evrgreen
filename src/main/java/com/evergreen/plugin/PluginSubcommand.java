package com.evergreen.plugin;

import com.evergreen.subcommand.Subcommand;

public class PluginSubcommand extends Subcommand implements PluginContract {
    private String pluginPath;
    public PluginSubcommand(String pluginName, String pluginPath) {
        this.setName(pluginName);
        this.pluginPath = pluginPath;
    }

    public String getPluginPath() {
        return pluginPath;
    }

    public void setPluginPath(String pluginPath) {
        this.pluginPath = pluginPath;
    }

    @Override
    public void execute() {

    }
}
