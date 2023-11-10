package com.blckroot.sdk.command.framework.plugin;

import com.blckroot.sdk.command.executable.CallableCommand;

import java.util.ArrayList;
import java.util.List;

public class PluginCommand extends CallableCommand {
    private final String executableFilePath;

    public PluginCommand(String name, String executableFilePath) {
        super(name);
        this.executableFilePath = executableFilePath;
    }

    public String getExecutableFilePath() {
        return executableFilePath;
    }

    @Override
    public Integer call() {
        try {
            List<String> arguments = new ArrayList<>();
            return 0;
        } finally {

        }
    }
}
