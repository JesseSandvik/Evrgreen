package com.blckroot.sdk.command.framework.command.decorator.plugin;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.FrameworkCommandDecorator;

public class ExecutePlugin extends FrameworkCommandDecorator {

    public ExecutePlugin(FrameworkBaseCommand frameworkCommand) {
        super(frameworkCommand);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("[ SUCCESSFULLY EXECUTED PROGRAM AT RUNTIME ]");
        return super.call();
    }
}
