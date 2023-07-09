package com.evergreen;

import com.evergreen.plugin.PluginContract;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.util.List;

@Command(name = "evgr")
public class MainApp {
    private List<PluginContract> plugins;
    public static void main(String[] args) {
        int exitCode = new CommandLine(new MainApp()).execute(args);
        System.exit(exitCode);
    }
}
