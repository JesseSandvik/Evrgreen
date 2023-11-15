package com.blckroot.sdk.logger;

import com.blckroot.sdk.logger.configurator.LogConfigurator;

import static java.lang.System.Logger.Level.*;

public class Main {
    public static void main(String[] args) {
        LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.enableConsoleLogging(true);
        logConfigurator.enableRollingFileSystemLogging(true);
        logConfigurator.initializeLogger();
        logConfigurator.setLevel(TRACE);

        System.Logger logger = System.getLogger(Main.class.getName());
        logger.log(WARNING, "warning log level test");
        logger.log(ERROR, "error log level test");
        logger.log(INFO, "info log level test");
        logger.log(DEBUG, "debug log level test");
        logger.log(TRACE, "trace log level test");
    }
}
