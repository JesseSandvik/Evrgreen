package com.blckroot.sdk.command.service;

import com.blckroot.sdk.command.executable.CallableCommand;

public class CommandService implements CommandServiceContract {
    private final CommandServiceUtility commandServiceUtility;

    public CommandService(CallableCommand rootCommand) {
        this.commandServiceUtility = new CommandServiceUtility(rootCommand);
    }

    @Override
    public Integer parse(String[] arguments) {
        return commandServiceUtility.parse(arguments);
    }
}
