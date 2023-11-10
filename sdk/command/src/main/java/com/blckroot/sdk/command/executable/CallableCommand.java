package com.blckroot.sdk.command.executable;

import com.blckroot.sdk.command.model.Command;

import java.util.concurrent.Callable;

public class CallableCommand extends Command implements Callable<Integer> {
    private boolean executesWithoutArguments = false;
    private CallableCommand[] callableSubcommands;

    public CallableCommand(String name) {
        setName(name);
    }

    public boolean isExecutesWithoutArguments() {
        return executesWithoutArguments;
    }

    public void setExecutesWithoutArguments(boolean executesWithoutArguments) {
        this.executesWithoutArguments = executesWithoutArguments;
    }

    public CallableCommand[] getCallableSubcommands() {
        return callableSubcommands;
    }

    public void setCallableSubcommands(CallableCommand[] callableSubcommands) {
        this.callableSubcommands = callableSubcommands;
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
