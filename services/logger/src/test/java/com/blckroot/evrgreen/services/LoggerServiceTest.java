package com.blckroot.evrgreen.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerServiceTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        out.reset();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void LOGGER_SERVICE__log_fatal() {
        String expected = "fatal log message";
        LoggerService loggerService = new LoggerService();
        loggerService.fatal(expected);

        assertTrue(out.toString().contains(expected));
    }

    @Test
    void LOGGER_SERVICE__log_error() {
        String expected = "error log message";
        LoggerService loggerService = new LoggerService();
        loggerService.error(expected);

        assertTrue(out.toString().contains(expected));
    }

    @Test
    void LOGGER_SERVICE__log_warn() {
        String expected = "warn log message";
        LoggerService loggerService = new LoggerService();
        loggerService.setLogLevel("warn");
        loggerService.warn(expected);

        assertTrue(out.toString().contains(expected));
    }

    @Test
    void LOGGER_SERVICE__log_info() {
        String expected = "info log message";
        LoggerService loggerService = new LoggerService();
        loggerService.setLogLevel("info");
        loggerService.info(expected);

        assertTrue(out.toString().contains(expected));
    }

    @Test
    void LOGGER_SERVICE__log_debug() {
        String expected = "debug log message";
        LoggerService loggerService = new LoggerService();
        loggerService.setLogLevel("debug");
        loggerService.info(expected);

        assertTrue(out.toString().contains(expected));
    }

    @Test
    void LOGGER_SERVICE__log_trace() {
        String expected = "trace log message";
        LoggerService loggerService = new LoggerService();
        loggerService.setLogLevel("trace");
        loggerService.trace(expected);

        assertTrue(out.toString().contains(expected));
    }
}
