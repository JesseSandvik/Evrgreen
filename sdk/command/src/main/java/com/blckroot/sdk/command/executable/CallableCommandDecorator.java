package com.blckroot.sdk.command.executable;

import java.util.concurrent.Callable;

public class CallableCommandDecorator implements Callable<Integer> {
    protected final CallableCommand callableCommand;

    public CallableCommandDecorator(CallableCommand callableCommand) {
        this.callableCommand = callableCommand;
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
