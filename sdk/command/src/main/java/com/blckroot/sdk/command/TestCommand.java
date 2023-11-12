package com.blckroot.sdk.command;

import com.blckroot.sdk.command.framework.command.FrameworkCommand;

public class TestCommand extends FrameworkCommand {
    public TestCommand() {
        super("test");
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("[ SUCCESSFULLY EXECUTED TEST COMMAND ]");
        return 0;
    }
}
