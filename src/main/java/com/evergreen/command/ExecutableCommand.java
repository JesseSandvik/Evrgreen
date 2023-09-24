package com.evergreen.command;

import java.util.concurrent.Callable;

public class ExecutableCommand extends Command implements Callable<Integer> {
    public ExecutableCommand(String name) {
        super(name);
    }

    public ExecutableCommand(String name, String version) {
        super(name, version);
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
