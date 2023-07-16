package com.evergreen;

import com.evergreen.picocli.RootCommandSpec;
import picocli.CommandLine;
import picocli.CommandLine.Model.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        CommandSpec rootSpec = CommandSpec.wrapWithoutInspection((Runnable) () -> {});
        rootSpec.name("evgr");
        CommandLine rootCommand = new CommandLine(rootSpec);

        // help section keys
        final String SECTION_KEY_ENV_HEADING = "environmentVariablesHeading";
        final String SECTION_KEY_ENV_DETAILS = "environmentVariables";
// ...

// the data to display
        Map<String, String> env = new LinkedHashMap<>();
        env.put("evgr run", "explanation of foo");
        env.put("evgr list", "explanation of bar");
        env.put("evgr lint", "xxxx yyyy zzz");
        env.put("evgr help", "Displays this help message");

// register the custom section renderers
        rootCommand.getHelpSectionMap().put(SECTION_KEY_ENV_HEADING,
                help -> help.createHeading("Available Commands:%n"));
        rootCommand.getHelpSectionMap().put(SECTION_KEY_ENV_DETAILS,
                help -> help.createTextTable(env).toString());

// specify the location of the new sections
        List<String> keys = new ArrayList<>(rootCommand.getHelpSectionKeys());
        int index = keys.indexOf(CommandLine.Model.UsageMessageSpec.SECTION_KEY_FOOTER_HEADING);
        keys.add(index, SECTION_KEY_ENV_HEADING);
        keys.add(index + 1, SECTION_KEY_ENV_DETAILS);
        rootCommand.setHelpSectionKeys(keys);

        if (args.length < 1) {
            rootCommand.usage(System.out);
            System.exit(0);
        }

        System.exit(rootCommand.execute(args));
    }
}
