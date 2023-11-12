package com.blckroot.sdk.command;

import com.blckroot.sdk.command.callable.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FrameworkBaseCommand command = new LoadPropertiesAtRuntime(new ExecuteProgramAtRuntime(new Test("test")));
        int exitCode = command.call();
        System.exit(exitCode);
    }
}
