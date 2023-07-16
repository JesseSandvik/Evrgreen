package com.evergreen;

import com.evergreen.picocli.RootCommand;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(RootCommand).execute(args);
        System.exit(exitCode);
    }
}
