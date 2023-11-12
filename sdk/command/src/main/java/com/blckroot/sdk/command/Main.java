package com.blckroot.sdk.command;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.properties.SetAttributesFromProperties;

public class Main {
    public static void main(String[] args) throws Exception {
        String propertiesFileDirectory = "command/src/test/resources/";
        FrameworkBaseCommand command = new SetAttributesFromProperties(new TestACommand(), propertiesFileDirectory);

        int exitCode = command.call();
        System.exit(exitCode);
    }
}
