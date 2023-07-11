package com.evergreen.picocli.subcommand;

import com.evergreen.plugin.PluginContract;

public class SubcommandPlugin extends Subcommand implements PluginContract {
    String pluginPath;

    public SubcommandPlugin(String pluginName, String pluginPath) {
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
    public void execute() {}
}
