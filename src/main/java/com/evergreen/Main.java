package com.evergreen;

import com.evergreen.picocli.RootCommand;
import com.evergreen.picocli.subcommand.plugin.SubcommandPluginFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        RootCommand rootCommand = new RootCommand("evgr");

        if (args.length < 1) {
            rootCommand.getCommand().usage(System.out);
            System.exit(0);
        }

        SubcommandPluginFactory subcommandPluginFactory = new SubcommandPluginFactory();



        System.exit(rootCommand.getCommand().execute(args));
    }
}
