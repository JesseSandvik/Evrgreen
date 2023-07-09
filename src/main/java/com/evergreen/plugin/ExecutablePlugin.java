package com.evergreen.plugin;

public class ExecutablePlugin implements PluginContract {
    private final String pluginExecutablePath;

    public ExecutablePlugin(String pluginExecutablePath) {
        this.pluginExecutablePath = pluginExecutablePath;
    }

    @Override
    public void execute() {}
}
