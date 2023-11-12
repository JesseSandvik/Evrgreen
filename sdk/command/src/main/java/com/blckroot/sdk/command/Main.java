package com.blckroot.sdk.command;

import com.blckroot.sdk.command.callable.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String propertiesFileDirectory = "command/src/main/resources/";
        FrameworkBaseCommand command =
                new LoadPropertiesAtRuntime(new ExecuteProgramAtRuntime(new Test("test")), propertiesFileDirectory);
        int exitCode = command.call();

        System.out.println("VERSION: " + command.getVersion());
        System.out.println("SYNOPSIS: " + command.getSynopsis());
        System.out.println("DESCRIPTION: " + command.getDescription());
        System.out.println("EXECUTES WITHOUT ARGUMENTS: " + command.isExecutesWithoutArguments());

        System.exit(exitCode);
    }
}
