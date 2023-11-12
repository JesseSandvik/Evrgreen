package com.blckroot.sdk.command.callable;

public class LoadPropertiesAtRuntime extends FrameworkCommandDecorator {

    public LoadPropertiesAtRuntime(FrameworkBaseCommand frameworkCommand) {
        super(frameworkCommand);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("[ SUCCESSFULLY LOADED PROPERTIES AT RUNTIME ]");
        return super.call();
    }
}
