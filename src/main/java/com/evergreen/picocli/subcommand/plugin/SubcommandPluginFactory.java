package com.evergreen.picocli.subcommand.plugin;

import com.evergreen.plugin.Plugin;
import com.evergreen.plugin.handlers.BaseHandler;
import com.evergreen.plugin.handlers.Handler;
import com.evergreen.plugin.handlers.PluginExistsHandler;

import java.util.List;

public class SubcommandPluginFactory {
    public List<SubcommandPlugin> subcommandPlugins;
    public void addSubcommandPlugin(String pluginName, String pluginPath) {

        Handler handler = new PluginExistsHandler()
    }
}
