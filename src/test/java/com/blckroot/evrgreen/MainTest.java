package com.blckroot.evrgreen;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        Main mn = new Main();
        CommandLine cmd = new CommandLine(mn);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int exitCode = cmd.execute("HELLO-WORLD!");
        assertEquals(0, exitCode);
    }
}