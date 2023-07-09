package com.evergreen.plugin;

import com.evergreen.subcommand.Subcommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PluginSubcommand extends Subcommand implements PluginContract {
    private String pluginPath;
    public PluginSubcommand(String pluginName, String pluginPath) {
        this.setName(pluginName);
        this.pluginPath = pluginPath;
    }

    public String getPluginPath() {
        return pluginPath;
    }

    public void setPluginPath(String pluginPath) {
        this.pluginPath = pluginPath;
    }

    @Override
    public String toString() {
        return "PluginSubcommand{" +
                "pluginPath='" + pluginPath + '\'' +
                '}';
    }

    @Override
    public void execute() {
        final ProcessBuilder build = new ProcessBuilder();
        // TODO: convert PluginSubcommand data to an ArrayList/List<String> and feed to build.command()
        build.command(this.pluginPath);
    }
}
