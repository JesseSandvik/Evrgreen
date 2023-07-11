package com.evergreen.plugin.handlers;

import com.evergreen.plugin.PluginContract;

import java.io.File;

public class PluginExecutesHandler extends BaseHandler {
    private PluginContract plugin;
    @Override
    public boolean handle(PluginContract plugin) {
        File executablePlugin = new File(plugin);
        return false;
    }
}
