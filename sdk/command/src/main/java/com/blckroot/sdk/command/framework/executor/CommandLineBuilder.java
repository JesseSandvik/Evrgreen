package com.blckroot.sdk.command.framework.executor;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Model.OptionSpec;

import static java.lang.System.Logger.Level.*;

class CommandLineBuilder {
    private static final System.Logger LOGGER = System.getLogger(CommandLineBuilder.class.getName());
    private final FrameworkBaseCommand rootFrameworkBaseCommand;
    private final CommandSpec rootCommandSpec;

    CommandLineBuilder(FrameworkBaseCommand frameworkBaseCommand) {
        LOGGER.log(TRACE, CommandLineBuilder.class.getName());
        this.rootFrameworkBaseCommand = frameworkBaseCommand;
        this.rootCommandSpec = CommandSpec.create().name(frameworkBaseCommand.getName());
    }

    public CommandLineBuilder addStandardUsageHelpOption(CommandSpec commandSpec) {
        LOGGER.log(DEBUG, "adding standard usage help option for command: " + commandSpec.name());
        commandSpec.addOption(OptionSpec
                .builder("--help", "-h")
                .usageHelp(true)
                .build());
        return this;
    }

    public CommandLineBuilder addStandardVersionHelpOption(CommandSpec commandSpec) {
        LOGGER.log(DEBUG, "adding standard version help option for command: " + commandSpec.name());
        commandSpec.addOption(OptionSpec
                .builder("--version", "-v")
                .versionHelp(true)
                .build());
        return this;
    }

    public picocli.CommandLine build() {
        LOGGER.log(TRACE, "executing build method for command: " + rootCommandSpec.name());
        addStandardUsageHelpOption(rootCommandSpec);
        if (rootFrameworkBaseCommand.getVersion() != null) {
            addStandardVersionHelpOption(rootCommandSpec);
        }

        return new picocli.CommandLine(rootCommandSpec);
    }
}
