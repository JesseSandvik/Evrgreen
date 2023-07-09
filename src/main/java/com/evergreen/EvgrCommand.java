package com.evergreen;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name="evgr")
public class EvgrCommand implements Runnable {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new EvgrCommand()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {}
}
