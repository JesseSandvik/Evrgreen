package com.blckroot.sdk.command.framework.service;

import com.blckroot.sdk.command.model.Option;
import com.blckroot.sdk.command.model.PositionalParameter;
import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Model.PositionalParamSpec;
import picocli.CommandLine.Model.OptionSpec;

class CommandLineBuilder {
    private final CallableCommand rootCommand;
    private final CommandSpec rootCommandSpec;

    CommandLineBuilder(CallableCommand rootCommand) {
        this.rootCommand = rootCommand;
        this.rootCommandSpec = CommandSpec.create();
    }

    private void addStandardUsageHelpOption() {
        rootCommandSpec.addOption(OptionSpec
                .builder("--help", "-h")
                .usageHelp(true)
                .build());
    }

    private void addStandardVersionHelpOption() {
        rootCommandSpec.addOption(OptionSpec
                .builder("--version", "-v")
                .versionHelp(true)
                .build());
    }

    private void addPositionalParameter(PositionalParameter positionalParameter) {
        rootCommandSpec.addPositional(PositionalParamSpec
                .builder()
                .paramLabel(positionalParameter.getLabel())
                .description(positionalParameter.getSynopsis())
                .build());
    }

    private void addOption(Option option) {
        OptionSpec.Builder optionSpecBuilder;

        if (option.getShortName() != null) {
            optionSpecBuilder = OptionSpec.builder(option.getLongName(), option.getShortName());
        } else {
            optionSpecBuilder = OptionSpec.builder(option.getLongName());
        }

        if (option.getLabel() != null) {
            optionSpecBuilder
                    .paramLabel(option.getLabel())
                    .type(String.class);
        } else {
            optionSpecBuilder.type(Boolean.class);
        }

        optionSpecBuilder.description(option.getSynopsis());
        rootCommandSpec.addOption(optionSpecBuilder.build());
    }

    private void addSubcommand(CommandLine subcommand) {
        rootCommandSpec.addSubcommand(subcommand.getCommandName(), subcommand);
    }

    public CommandLine build() {
        rootCommandSpec.name(rootCommand.getName());
        addStandardUsageHelpOption();

        if (rootCommand.getVersion() != null) {
            rootCommandSpec.version(rootCommand.getVersion());
            addStandardVersionHelpOption();
        }

        if (rootCommand.getPositionalParameters() != null && rootCommand.getPositionalParameters().length >= 1) {
            for (PositionalParameter positionalParameter : rootCommand.getPositionalParameters()) {
                addPositionalParameter(positionalParameter);
            }
        }

        if (rootCommand.getOptions() != null && rootCommand.getOptions().length >= 1) {
            for (Option option : rootCommand.getOptions()) {
                addOption(option);
            }
        }

        return new CommandLine(rootCommandSpec);
    }
}
