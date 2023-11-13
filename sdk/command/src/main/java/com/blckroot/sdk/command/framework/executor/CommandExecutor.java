package com.blckroot.sdk.command.framework.executor;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;

public class CommandExecutor implements CommandExecutorContract {
    private final CommandExecutorUtility executorUtility;

    public CommandExecutor(FrameworkBaseCommand frameworkBaseCommand) {
        this.executorUtility = new CommandExecutorUtility(frameworkBaseCommand);
    }

    @Override
    public Integer execute(String[] arguments) {
        return executorUtility.execute(arguments);
    }
}
