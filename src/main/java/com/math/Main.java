package com.math;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name="math", subcommands = {Addition.class})
public class Main implements Callable<Integer> {
    char[] operators = { '+', '-', '*', '/'};

    @Override
    public Integer call() {
        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
