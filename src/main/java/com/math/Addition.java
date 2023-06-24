package com.math;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "add", description = "perform addition")
public class Addition implements Callable<Integer> {
    @Option(names = {"-f", "--firstNum"}) private String firstNum;
    @Option(names = {"-s", "--secondNum"}) private String secondNum;
    @Override
    public Integer call() {
        try {
            double firstNumToAdd = Double.parseDouble(firstNum);
            double secondNumToAdd = Double.parseDouble(secondNum);

            System.out.println(firstNumToAdd + secondNumToAdd);
            return 0;
        } catch (NumberFormatException exception) {
            System.out.println("WHAT THE HELL DID YOU DO");
            return 1;
        }
    }
}

