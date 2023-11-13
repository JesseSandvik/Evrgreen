package com.blckroot.sdk.command.framework.executor;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import picocli.CommandLine;

class CommandExecutorUtility implements CommandExecutorContract {
    private final FrameworkBaseCommand frameworkBaseCommand;

    CommandExecutorUtility(FrameworkBaseCommand frameworkBaseCommand) {
        this.frameworkBaseCommand = frameworkBaseCommand;
    }

    public Integer execute(String[] arguments) {
        CommandLine commandLine = new CommandLineBuilder(frameworkBaseCommand).build();
        return commandLine.execute(arguments);
    }
}
