package com.blckroot.sdk.command.framework.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CommandServiceTest {
    final PrintStream originalOut = System.out;
    final PrintStream originalErr = System.err;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ByteArrayOutputStream err = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        out.reset();
        err.reset();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    // * COMMAND SERVICE | PARSE | EXIT CODES | ********************************************************************* //

    @Test
    void COMMAND_SERVICE__parse__success__exit_code() {
//        int expected = 0;
//        String[] arguments = "-h".split(" ");
//        CallableCommand command = new CallableCommand("test-command");
//        command.setName("test");
//
//        CommandService commandService = new CommandService(command);
//        int actual = commandService.parse(arguments);
//        assertEquals(expected, actual);
    }
}
