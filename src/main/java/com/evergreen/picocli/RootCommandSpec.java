package com.evergreen.picocli;

import com.evergreen.picocli.subcommand.Subcommand;
import picocli.CommandLine;
import picocli.CommandLine.Model.*;

public class RootCommandSpec {
    private final CommandSpec rootSpec;
    public RootCommandSpec(String commandName) {
        this.rootSpec = CommandSpec.wrapWithoutInspection((Runnable) () -> {});
        this.rootSpec.name(commandName);
    }
    public void addSubcommand(Subcommand subcommand) {
        this.rootSpec.addSubcommand(
                subcommand.getName(),
                CommandSpec.wrapWithoutInspection((Runnable) () -> {
                }));
    }
    public CommandLine getCommand() {
        return new CommandLine(this.rootSpec);
    }
    public CommandSpec getSpec() {
        return rootSpec;
    }
}
