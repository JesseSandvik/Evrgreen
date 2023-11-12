package com.blckroot.sdk.command.executable;

import com.blckroot.sdk.command.model.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableCommand extends Command implements Callable<Integer> {
    private final List<CallableCommand> callableSubcommands = new ArrayList<>();

    public CallableCommand(String name) {
        super(name);
    }

    public List<CallableCommand> getCallableSubcommands() {
        return callableSubcommands;
    }

    public void addCallableSubcommand(CallableCommand callableSubcommand) {
        callableSubcommands.add(callableSubcommand);
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
