package com.evergreen.picocli;

import com.evergreen.command.Command;
import picocli.CommandLine.Model.*;

public class CommandLineBuilder {
    private final Command command;
    private final CommandSpec commandSpec;

    public CommandLineBuilder(Command command, CommandSpec commandSpec) {
        this.command = command;
        this.commandSpec = CommandSpec.create().name(command.getName());

        this.commandSpec
                .usageMessage()
                .autoWidth(true)
                .adjustLineBreaksForWideCJKCharacters(true)
                .abbreviateSynopsis(true)
                .commandListHeading("\nCommands:%n")
                .optionListHeading("\nOptions:%n")
                .parameterListHeading("\nParameters:%n");

        if (command.getVersion() != null) {
            this.commandSpec.version(command.getVersion());
        }

        if (command.getUsageDescriptionSynopsis() != null) {
            this.commandSpec.usageMessage().description(command.getUsageDescriptionSynopsis());
        }

        if (command.getUsageDescriptionFull() != null) {
            this.commandSpec.usageMessage().footer("\n" + command.getUsageDescriptionFull() + "%n");
        }
    }
}
