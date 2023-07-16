package com.evergreen.picocli;

import com.evergreen.picocli.subcommand.Subcommand;
import picocli.CommandLine.Model.*;

public class RootCommand {
    private final CommandSpec rootSpec;
    public RootCommand(String commandName) {
        this.rootSpec = CommandSpec.create();
        rootSpec.name(commandName);
    }
    public void addSubcommand(Subcommand subcommand) {
        this.rootSpec.addSubcommand(
                subcommand.getName(),
                CommandSpec.wrapWithoutInspection((Runnable) () -> {}));
    }
}
