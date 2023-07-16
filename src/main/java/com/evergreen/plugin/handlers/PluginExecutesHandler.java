package com.evergreen.plugin.handlers;

import com.evergreen.plugin.Plugin;

public class PluginExecutesHandler extends BaseHandler {
    private final Plugin plugin;
    public PluginExecutesHandler(Plugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean handle(String pluginPath) {
        if (plugin.isExecutable(pluginPath)) {
            return handleNext(pluginPath);
        }
        return false;
    }
}
