package com.evergreen;

import com.evergreen.plugin.InvalidPluginException;
import com.evergreen.plugin.PluginContract;
import com.evergreen.plugin.PluginSubcommandFactory;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private final List<PluginContract> plugins;
    public MainApp() {
        plugins = new ArrayList<>();
    }
    public void registerPlugin(PluginContract plugin) {
        plugins.add(plugin);
    }
    public void executePlugins() {
        for (PluginContract plugin : plugins) {
            plugin.execute();
        }
    }
    public static void main(String[] args) {
        MainApp app = new MainApp();

        try {
            String pluginName = "name";
            String pluginPath = "somepath";
            PluginContract plugin = PluginSubcommandFactory.createPlugin(pluginName, pluginPath);

            app.registerPlugin(plugin);
        } catch (InvalidPluginException e) {
            throw new RuntimeException(e);
        }

        app.executePlugins();

        int exitCode = new CommandLine(app).execute(args);
        System.exit(exitCode);
    }
}
