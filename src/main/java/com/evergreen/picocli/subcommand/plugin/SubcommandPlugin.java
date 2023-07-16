package com.evergreen.picocli.subcommand.plugin;

import com.evergreen.picocli.subcommand.Subcommand;
import com.evergreen.plugin.Plugin;

import java.util.List;
import java.util.Map;

public class SubcommandPlugin extends Subcommand {
    private final Plugin plugin;
    public SubcommandPlugin(String name, Plugin plugin) {
        super(name);
        this.plugin = plugin;
    }
    public SubcommandPlugin(String name, String description, Plugin plugin) {
        super(name, description);
        this.plugin = plugin;
    }
    public SubcommandPlugin(String name, String description, List<String> parameters, Plugin plugin) {
        super(name, description, parameters);
        this.plugin = plugin;
    }
    public SubcommandPlugin(String name, String description, List<String> parameters, Map<Character, String> options, Plugin plugin) {
        super(name, description, parameters, options);
        this.plugin = plugin;
    }
    public Plugin getPlugin() {
        return plugin;
    }
}
