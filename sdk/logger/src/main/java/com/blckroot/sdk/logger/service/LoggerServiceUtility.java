package com.blckroot.sdk.logger.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

class LoggerServiceUtility implements LoggerServiceContract {
    private final Logger logger;

    public LoggerServiceUtility() {
        // Reload log4j2 configuration before initializing...
        ((org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false)).reconfigure();
        this.logger = LogManager.getRootLogger();
    }

    public LoggerServiceUtility(String className) {
        // Reload log4j2 configuration before initializing...
        ((org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false)).reconfigure();
        this.logger = LogManager.getLogger(className);
    }

    @Override
    public void setLogLevel(String level) {
        Configurator.setLevel(logger.getName(), Level.valueOf(level));
    }

    @Override
    public void fatal(String message) {
        logger.fatal(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void trace(String message) {
        logger.trace(message);
    }
}
