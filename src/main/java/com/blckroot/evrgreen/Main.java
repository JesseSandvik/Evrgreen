package com.blckroot.evrgreen;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "Main")
class Main implements Callable<Integer> {

    @Parameters(index = "0", description = "Hello World!") private String firstArg;
    @Override
    public Integer call() throws Exception {
        System.out.println(firstArg);
        return 0;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}