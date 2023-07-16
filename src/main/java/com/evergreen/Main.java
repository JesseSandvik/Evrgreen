package com.evergreen;

import com.evergreen.picocli.RootCommand;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        RootCommand rootCommand = new RootCommand("evgr");
        CommandLine root = rootCommand.getRootCommand();

        if (args.length < 1) {
            root.usage(System.out);
            System.exit(0);
        }

        System.exit(new CommandLine(rootCommand.getRootSpec()).execute(args));
    }
}
