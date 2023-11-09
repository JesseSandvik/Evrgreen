package com.blckroot.sdk.command.executable;

import com.blckroot.sdk.command.model.Command;

import java.util.concurrent.Callable;

public class CallableCommand extends Command implements Callable<Integer> {
    private CallableCommand[] callableSubcommands;

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
