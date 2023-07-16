package com.evergreen.picocli.subcommand.plugin;

import com.evergreen.picocli.subcommand.Subcommand;
import com.evergreen.plugin.InvalidPluginException;
import com.evergreen.plugin.Plugin;
import com.evergreen.plugin.PluginContract;

public class SubcommandPlugin extends Subcommand {
    private PluginContract plugin;
    public SubcommandPlugin(String pluginName, String pluginPath) throws InvalidPluginException {
        PluginContract plugin = new Plugin(pluginPath);
    }
}
