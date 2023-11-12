package com.blckroot.sdk.command;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.properties.LoadPropertiesFromFile;
import com.blckroot.sdk.command.framework.command.decorator.properties.SetAttributesFromProperties;

public class Main {
    public static void main(String[] args) throws Exception {
        String propertiesFileDirectory = "command/src/test/resources/";
        FrameworkBaseCommand command = new LoadPropertiesFromFile(
                new SetAttributesFromProperties(new TestCommand()), propertiesFileDirectory);

        int exitCode = command.call();
        System.out.println("VERSION: " + command.getVersion());
        System.out.println("SYNOPSIS: " + command.getSynopsis());
        System.out.println("DESCRIPTION: " + command.getDescription());
        System.out.println("EXECUTES WITHOUT ARGUMENTS: " + command.isExecutesWithoutArguments());

        System.exit(exitCode);
    }
}
