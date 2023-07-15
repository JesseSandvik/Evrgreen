package com.evergreen.plugin.handlers;

import java.io.File;

public class PluginExecutesHandler implements Handler {
    @Override
    public boolean handle(String pluginPath) {
        File plugin = new File(pluginPath);
        return plugin.canExecute();
    }
}
