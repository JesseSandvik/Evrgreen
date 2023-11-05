package com.blckroot.evrgreen.services;

public class LoggerService implements LoggerServiceContract {
    private final LoggerServiceUtility loggerServiceUtility;

    public LoggerService() {
        this.loggerServiceUtility = new LoggerServiceUtility();
    }

    public LoggerService(String className) {
        this.loggerServiceUtility = new LoggerServiceUtility(className);
    }

    @Override
    public void setLogLevel(String level) {
        loggerServiceUtility.setLogLevel(level);
    }

    @Override
    public void fatal(String message) {
        loggerServiceUtility.fatal(message);
    }

    @Override
    public void error(String message) {
        loggerServiceUtility.error(message);
    }

    @Override
    public void warn(String message) {
        loggerServiceUtility.warn(message);
    }

    @Override
    public void info(String message) {
        loggerServiceUtility.info(message);
    }

    @Override
    public void debug(String message) {
        loggerServiceUtility.debug(message);
    }

    @Override
    public void trace(String message) {
        loggerServiceUtility.trace(message);
    }
}
