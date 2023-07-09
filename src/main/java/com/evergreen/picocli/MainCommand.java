package com.evergreen.picocli;

import picocli.CommandLine.Model.*;

public class MainCommand implements Runnable {
    private CommandSpec spec;
    public void addSubcommand(String subcommandName, CommandSpec subcommandSpec) {
        spec.addSubcommand(subcommandName, subcommandSpec);
    }

    public void addSubcommandOption(String subcommandName, String shortOption, String longOption) {}
    @Override
    public void run() {
        final CommandSpec rootspec = CommandSpec.create();
        rootspec.name("evgr");
    }
}
