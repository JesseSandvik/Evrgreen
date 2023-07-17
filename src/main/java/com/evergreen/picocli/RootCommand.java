package com.evergreen.picocli;

import com.evergreen.picocli.subcommand.Subcommand;
import picocli.CommandLine;
import picocli.CommandLine.Model.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class RootCommand {
    private final CommandSpec rootSpec;
    private final CommandLine rootCommand;
    public RootCommand(String commandName) throws IOException {
        this.rootSpec = CommandSpec.wrapWithoutInspection((Runnable) () -> {});
        this.rootSpec.name(commandName);
        this.rootCommand = new CommandLine(this.rootSpec);
        getConfigurationDetails();
        setUsage();
    }
    public void addSubcommand(Subcommand subcommand) {
        this.rootSpec.addSubcommand(
                subcommand.getName(),
                CommandSpec.wrapWithoutInspection((Runnable) () -> {}));
    }
    private void setUsage() {
        final String SECTION_KEY_AVAILABLE_COMMANDS_HEADING = "availableCommandsHeading";
        final String SECTION_KEY_AVAILABLE_COMMANDS_DETAILS = "availableCommandsDetails";

        Map<String, String> availableCommands  = new LinkedHashMap<>();
        availableCommands.put("run", "Run x y z");
        availableCommands.put("list", "List x y z");
        availableCommands.put("lint", "Lint x y z");
        availableCommands.put("help", "Displays this help message");

        this.rootCommand.getHelpSectionMap().put(SECTION_KEY_AVAILABLE_COMMANDS_HEADING,
                help -> help.createHeading("Available Commands:%n"));
        this.rootCommand.getHelpSectionMap().put(SECTION_KEY_AVAILABLE_COMMANDS_DETAILS,
                help -> help.createTextTable(availableCommands).toString());

        List<String> usageKeys = new ArrayList<>(this.rootCommand.getHelpSectionKeys());
        int usageFooterIndex = usageKeys.indexOf(UsageMessageSpec.SECTION_KEY_FOOTER_HEADING);
        usageKeys.add(usageFooterIndex, SECTION_KEY_AVAILABLE_COMMANDS_HEADING);
        usageKeys.add(usageFooterIndex + 1, SECTION_KEY_AVAILABLE_COMMANDS_DETAILS);
        this.rootCommand.setHelpSectionKeys(usageKeys);
    }
    private void getConfigurationDetails() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("*.properties")) {
            Properties props = new Properties();

            props.load(input);

            System.out.println(props.getProperty("name"));
            System.out.println(props.getProperty("description"));
            System.out.println(props.getProperty("version"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public CommandLine getCommand() {
        return rootCommand;
    }
    public CommandSpec getSpec() {
        return rootSpec;
    }
}
