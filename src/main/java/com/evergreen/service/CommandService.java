package com.evergreen.service;

import com.evergreen.command.ExecutableCommand;
import com.evergreen.contract.CommandServiceContract;
import com.evergreen.picocli.CommandServiceUtility;

public class CommandService implements CommandServiceContract {
    private final CommandServiceUtility commandServiceUtility;

    public CommandService(ExecutableCommand executableCommand) {
        this.commandServiceUtility = new CommandServiceUtility(executableCommand);
    }

    @Override
    public Integer execute(String[] args) {
        return this.commandServiceUtility.execute(args);
    }
}
