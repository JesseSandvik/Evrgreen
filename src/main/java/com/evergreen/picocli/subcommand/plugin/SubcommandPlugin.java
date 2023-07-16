package com.evergreen.picocli.subcommand.plugin;

import com.evergreen.picocli.subcommand.Subcommand;
import com.evergreen.plugin.Plugin;
import com.evergreen.plugin.PluginContract;
import com.evergreen.plugin.handlers.BaseHandler;
import com.evergreen.plugin.handlers.PluginExistsHandler;

public class SubcommandPlugin extends Subcommand {
    private PluginContract plugin;
    public SubcommandPlugin(String pluginName, String pluginPath) {
        PluginContract plugin = new Plugin();
    }
}
