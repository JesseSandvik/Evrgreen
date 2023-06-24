package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name="cmd")
public class Main implements Callable<Integer> {
    @Option(
            names = {"-m", "--message"},
            description = "The message you want to print."
    ) private String message;

    @Override
    public Integer call() {
        System.out.println(message);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
