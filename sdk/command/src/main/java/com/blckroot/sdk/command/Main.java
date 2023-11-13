package com.blckroot.sdk.command;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.framework.ExecutePlugin;
import com.blckroot.sdk.command.framework.command.decorator.framework.SetAttributesFromPropertiesFile;
import com.blckroot.sdk.command.framework.executor.CommandExecutor;
import com.blckroot.sdk.command.model.PositionalParameter;
import com.blckroot.sdk.logger.configurator.Configurator;

import static java.lang.System.Logger;
import static java.lang.System.Logger.Level.*;

public class Main {
    private static final Logger LOGGER = System.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Configurator configurator = new Configurator();
        configurator.setLevel(DEBUG);
        LOGGER.log(DEBUG, "debug test");
        LOGGER.log(ERROR, "error test");
        LOGGER.log(WARNING, "warn test");
        LOGGER.log(INFO, "info test");
        LOGGER.log(TRACE, "trace test");

        String propertiesFileDirectory = "command/src/test/resources/";

        PositionalParameter positionalParameter = new PositionalParameter();
        positionalParameter.setValue("Hello, World!");
        FrameworkBaseCommand testCommand = new TestACommand();
        testCommand.addPositionalParameter(positionalParameter);

        FrameworkBaseCommand command = new SetAttributesFromPropertiesFile(new ExecutePlugin(testCommand), propertiesFileDirectory);

        CommandExecutor commandExecutor = new CommandExecutor(command);
        int exitCode = commandExecutor.execute(args);
        System.exit(exitCode);
    }
}
