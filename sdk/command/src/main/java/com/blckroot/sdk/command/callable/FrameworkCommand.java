package com.blckroot.sdk.command.callable;

import com.blckroot.sdk.command.model.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class FrameworkCommand extends Command implements FrameworkBaseCommand, Callable<Integer>  {
    private final List<FrameworkCommand> frameworkSubcommands = new ArrayList<>();
    private final List<String> arguments = new ArrayList<>();

    public FrameworkCommand(String name) {
        super(name);
    }

    @Override
    public List<FrameworkCommand> getFrameworkSubcommands() {
        return frameworkSubcommands;
    }

    @Override
    public void addFrameworkSubcommand(FrameworkCommand subcommand) {
        frameworkSubcommands.add(subcommand);
    }

    @Override
    public List<String> getArguments() {
        return arguments;
    }

    @Override
    public void addArgument(String argument) {
        arguments.add(argument);
    }

    @Override
    public abstract Integer call() throws Exception;
}
