package com.blckroot.sdk.command.callable;

public class ExecuteProgramAtRuntime extends FrameworkCommandDecorator {

    public ExecuteProgramAtRuntime(FrameworkBaseCommand frameworkCommand) {
        super(frameworkCommand);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("[ SUCCESSFULLY EXECUTED PROGRAM AT RUNTIME ]");
        return super.call();
    }
}
