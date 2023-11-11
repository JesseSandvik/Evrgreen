package com.blckroot.sdk.command.executable;

import com.blckroot.sdk.command.model.Command;

import java.util.concurrent.Callable;

public class CallableCommand extends Command implements Callable<Integer> {

    public CallableCommand(String name) {
        super(name);
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
