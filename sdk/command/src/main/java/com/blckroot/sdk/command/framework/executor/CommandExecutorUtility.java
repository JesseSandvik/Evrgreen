package com.blckroot.sdk.command.framework.executor;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import picocli.CommandLine;

import static java.lang.System.Logger.Level.*;

class CommandExecutorUtility implements CommandExecutorContract {
    private static final System.Logger LOGGER = System.getLogger(CommandExecutorUtility.class.getName());
    private final FrameworkBaseCommand frameworkBaseCommand;

    CommandExecutorUtility(FrameworkBaseCommand frameworkBaseCommand) {
        LOGGER.log(TRACE, CommandExecutorUtility.class.getName());
        this.frameworkBaseCommand = frameworkBaseCommand;
    }

    public Integer execute(String[] arguments) {
        LOGGER.log(TRACE, "executing execute method for command: " + frameworkBaseCommand.getName());
        CommandLine commandLine = new CommandLineBuilder(frameworkBaseCommand).build();
        return commandLine.execute(arguments);
    }
}
