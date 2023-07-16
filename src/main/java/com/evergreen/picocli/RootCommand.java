package com.evergreen.picocli;

import com.evergreen.picocli.subcommand.Subcommand;
import picocli.CommandLine;
import picocli.CommandLine.Model.*;

import java.io.PrintWriter;

public class RootCommand {
    private final CommandSpec rootSpec;
    public RootCommand(String commandName) {
        this.rootSpec = CommandSpec.wrapWithoutInspection((Runnable) () -> {});
        this.rootSpec.name(commandName);
    }
    public void addSubcommand(Subcommand subcommand) {
        this.rootSpec.addSubcommand(
                subcommand.getName(),
                CommandSpec.wrapWithoutInspection((Runnable) () -> {
                }));
    }
    public CommandLine getRootCommand() {
        return new CommandLine(this.rootSpec);
    }
    public CommandSpec getRootSpec() {
        return rootSpec;
    }
}
