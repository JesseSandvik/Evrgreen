package com.evergreen.picocli;

import com.evergreen.command.Command;
import com.evergreen.command.Option;
import com.evergreen.command.PositionalParameter;
import picocli.CommandLine;
import picocli.CommandLine.Model.*;

public class CommandLineBuilder {
    private final Command command;
    private final CommandSpec commandSpec;

    public CommandLineBuilder(Command command) {
        this.command = command;
        this.commandSpec = CommandSpec.create().name(command.getName());

        this.commandSpec
                .usageMessage()
                .autoWidth(true)
                .adjustLineBreaksForWideCJKCharacters(true)
                .abbreviateSynopsis(true)
                .commandListHeading("\nCommands:%n")
                .optionListHeading("\nOptions:%n")
                .parameterListHeading("\nParameters:%n");

        if (command.getVersion() != null) {
            this.commandSpec.version(command.getVersion());
        }

        if (command.getUsageDescriptionSynopsis() != null) {
            this.commandSpec.usageMessage().description(command.getUsageDescriptionSynopsis());
        }

        if (command.getUsageDescriptionFull() != null) {
            this.commandSpec.usageMessage().footer("\n" + command.getUsageDescriptionFull() + "%n");
        }
    }

    public CommandLineBuilder addPositionalParameter(PositionalParameter positionalParameter) {
        this.commandSpec.addPositional(PositionalParamSpec
                .builder()
                .paramLabel(positionalParameter.label())
                .description(positionalParameter.description())
                .build()
        );
        return this;
    }

    public CommandLineBuilder addOption(Option option) {
        OptionSpec.Builder optionSpec = OptionSpec
                .builder(option.getNames())
                .description(option.getDescription())
                .type(option.getType());

        if (option.getParamLabel() != null) {
            optionSpec.paramLabel(option.getParamLabel());
        }

        this.commandSpec.addOption(optionSpec.build());
        return this;
    }

    public CommandLineBuilder addSubcommand(CommandLine subcommandLine) {
        this.commandSpec.addSubcommand(subcommandLine.getCommandName(), subcommandLine);
        return this;
    }

    public CommandLine build() {
        for (PositionalParameter positionalParameter : command.getPositionalParameters()) {
            this.addPositionalParameter(positionalParameter);
        }

        for (Option option : command.getOptions()) {
            this.addOption(option);
        }

        return new CommandLine(commandSpec);
    }
}
