package com.blckroot.sdk.command.framework.service;

import com.blckroot.sdk.command.executable.CallableCommand;
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
        int expected = 0;
        String[] arguments = "-h".split(" ");
        CallableCommand command = new CallableCommand("test-command");
        command.setName("test");

        CommandService commandService = new CommandService(command);
        int actual = commandService.parse(arguments);
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_SERVICE__parse__fail__exit_code() {
        int expected = 0;
        String[] arguments = "--bad-option".split(" ");
        CallableCommand command = new CallableCommand("test-command");
        command.setName("test");

        CommandService commandService = new CommandService(command);
        int actual = commandService.parse(arguments);
        assertNotEquals(expected, actual);
    }

    // * COMMAND SERVICE | USAGE HELP | OUTPUT | ******************************************************************** //

    @Test
    void COMMAND_SERVICE__fail__help_option__short_name__outputs_usage_help() {
        String[] arguments = "-bad-option".split(" ");
        CallableCommand command = new CallableCommand("test-command");
        command.setName("test-command");

        CommandService commandService = new CommandService(command);
        commandService.parse(arguments);

        assertTrue(err.toString().contains(command.getName()));
        assertTrue(err.toString().contains("-h"));
        assertTrue(err.toString().contains("--help"));
    }

    @Test
    void COMMAND_SERVICE__fail__help_option__long_name__outputs_usage_help() {
        String[] arguments = "--bad-option".split(" ");
        CallableCommand command = new CallableCommand("test-command");
        command.setName("test-command");

        CommandService commandService = new CommandService(command);
        commandService.parse(arguments);

        assertTrue(err.toString().contains(command.getName()));
        assertTrue(err.toString().contains("-h"));
        assertTrue(err.toString().contains("--help"));
    }

    @Test
    void COMMAND_SERVICE__success__help_option__short_name__outputs_usage_help() {
        String[] arguments = "-h".split(" ");
        CallableCommand command = new CallableCommand("test-command");
        command.setName("test-command");

        CommandService commandService = new CommandService(command);
        commandService.parse(arguments);

        assertTrue(out.toString().contains(command.getName()));
        assertTrue(out.toString().contains("-h"));
        assertTrue(out.toString().contains("--help"));
    }

    @Test
    void COMMAND_SERVICE__success__help_option__long_name__outputs_usage_help() {
        String[] arguments = "--help".split(" ");
        CallableCommand command = new CallableCommand("test-command");
        command.setName("test-command");

        CommandService commandService = new CommandService(command);
        commandService.parse(arguments);

        assertTrue(out.toString().contains(command.getName()));
        assertTrue(out.toString().contains("-h"));
        assertTrue(out.toString().contains("--help"));
    }
}
