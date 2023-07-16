package com.evergreen.plugin.handlers;

import com.evergreen.plugin.Plugin;

public class PluginExistsHandler extends BaseHandler {
    final private Plugin plugin;
    public PluginExistsHandler(Plugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean handle(String pluginPath) {
        if (plugin.exists(pluginPath)) {
            return handleNext(pluginPath);
        }
        return false;
    }
}
