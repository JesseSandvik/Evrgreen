package com.blckroot.sdk.command;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.framework.ExecutePlugin;
import com.blckroot.sdk.command.framework.command.decorator.framework.SetAttributesFromPropertiesFile;
import com.blckroot.sdk.command.model.PositionalParameter;

public class Main {
    public static void main(String[] args) throws Exception {
        String propertiesFileDirectory = "command/src/test/resources/";

        PositionalParameter positionalParameter = new PositionalParameter();
        positionalParameter.setValue("Hello, World!");
        FrameworkBaseCommand testCommand = new TestACommand();
        testCommand.addPositionalParameter(positionalParameter);

        FrameworkBaseCommand command = new SetAttributesFromPropertiesFile(new ExecutePlugin(testCommand), propertiesFileDirectory);

        int exitCode = command.call();
        System.exit(exitCode);
    }
}
