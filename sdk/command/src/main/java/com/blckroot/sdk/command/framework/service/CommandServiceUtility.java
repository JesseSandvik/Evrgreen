package com.blckroot.sdk.command.framework.service;

import com.blckroot.sdk.command.executable.CallableCommand;
import picocli.CommandLine;

class CommandServiceUtility implements CommandServiceContract {
    private final CallableCommand rootCommand;

    CommandServiceUtility(CallableCommand rootCommand) {
        this.rootCommand = rootCommand;
    }

    @Override
    public Integer parse(String[] arguments) {
        CommandLine commandLine = new CommandLineBuilder(rootCommand).build();
        return commandLine.execute(arguments);
    }
}
