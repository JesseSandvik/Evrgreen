package com.evergreen.picocli;

import com.evergreen.command.ExecutableCommand;
import com.evergreen.contract.CommandServiceContract;
import picocli.CommandLine;

public class CommandServiceUtility implements CommandServiceContract {
    private final ExecutableCommand rootCommand;

    public CommandServiceUtility(ExecutableCommand rootCommand) {
        this.rootCommand = rootCommand;
    }

    @Override
    public Integer execute(String[] args) {
        CommandLine rootCommandLine = new CommandLineBuilder(rootCommand).build();

        return rootCommandLine.execute(args);
    }
}
