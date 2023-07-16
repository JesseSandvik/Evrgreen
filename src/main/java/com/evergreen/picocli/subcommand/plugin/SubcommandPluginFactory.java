package com.evergreen.picocli.subcommand.plugin;

import com.evergreen.plugin.InvalidPluginException;
import com.evergreen.plugin.Plugin;
import com.evergreen.plugin.handlers.Handler;
import com.evergreen.plugin.handlers.PluginExecutesHandler;
import com.evergreen.plugin.handlers.PluginExistsHandler;

import java.util.List;

public class SubcommandPluginFactory {
    public List<SubcommandPlugin> subcommandPlugins;
    public void addSubcommandPlugin(String pluginName, String pluginPath) throws InvalidPluginException {
        Plugin plugin = new Plugin(pluginPath);
        Handler handler = new PluginExistsHandler(plugin)
                .setNextHandler(new PluginExecutesHandler(plugin));
        if (handler.handle(pluginPath)) {
            SubcommandPlugin subcommandPlugin = new SubcommandPlugin(pluginName, plugin);
            subcommandPlugins.add(subcommandPlugin);
        } else {
            throw new InvalidPluginException("An invalid plugin has been provided: " + pluginPath);
        }
    }
}
