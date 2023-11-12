package com.blckroot.sdk.command.callable;

public class Test extends FrameworkCommand {

    public Test(String name) {
        super(name);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("[ SUCCESSFULLY EXECUTED 'TEST' COMMAND ]");
        return 0;
    }
}
