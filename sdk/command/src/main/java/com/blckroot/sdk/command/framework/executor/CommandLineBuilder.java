package com.blckroot.sdk.command.framework.executor;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Model.OptionSpec;

class CommandLineBuilder {
    private final FrameworkBaseCommand rootFrameworkBaseCommand;
    private final CommandSpec rootCommandSpec;

    CommandLineBuilder(FrameworkBaseCommand frameworkBaseCommand) {
        this.rootFrameworkBaseCommand = frameworkBaseCommand;
        this.rootCommandSpec = CommandSpec.create().name(frameworkBaseCommand.getName());
    }

    public CommandLineBuilder addStandardUsageHelpOption(CommandSpec commandSpec) {
        commandSpec.addOption(OptionSpec
                .builder("--help", "-h")
                .usageHelp(true)
                .build());
        return this;
    }

    public CommandLineBuilder addStandardVersionHelpOption(CommandSpec commandSpec) {
        commandSpec.addOption(OptionSpec
                .builder("--version", "-v")
                .versionHelp(true)
                .build());
        return this;
    }

    public picocli.CommandLine build() {
        addStandardUsageHelpOption(rootCommandSpec);
        System.out.println(rootFrameworkBaseCommand.getVersion());
        if (rootFrameworkBaseCommand.getVersion() != null) {
            addStandardVersionHelpOption(rootCommandSpec);
        }

        return new picocli.CommandLine(rootCommandSpec);
    }
}
