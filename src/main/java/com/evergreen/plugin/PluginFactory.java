package com.evergreen.plugin;

import java.io.File;

public class PluginFactory {
    public static PluginContract createPlugin(String executablePluginPath) {
        return new ExecutablePlugin(executablePluginPath);
    }

    private static boolean isValidPlugin(String executablePluginPath) {
        File executablePlugin = new File(executablePluginPath);
    }
}
