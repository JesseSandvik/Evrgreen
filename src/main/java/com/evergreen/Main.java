package com.evergreen;

import com.evergreen.picocli.RootCommand;

public class Main {
    public static void main(String[] args) {

        RootCommand rootCommand = new RootCommand("evgr");

        if (args.length < 1) {
            rootCommand.getCommand().usage(System.out);
            System.exit(0);
        }

        System.exit(rootCommand.getCommand().execute(args));
    }
}
