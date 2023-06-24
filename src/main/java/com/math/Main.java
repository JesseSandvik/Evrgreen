package com.math;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name="cmd")
public class Main implements Callable<Integer> {
    @Option(
            names = {"-a", "--add"},
            description = "Perform addition."
    ) private String addElements;

    @Override
    public Integer call() {
        int firstInt = Character.getNumericValue(addElements.charAt(0));
        char operator = addElements.charAt(1);
        int secondInt = Character.getNumericValue(addElements.charAt(2));

        if (operator == '+') {
            System.out.println(firstInt + secondInt);
        }

        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
