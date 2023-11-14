package com.blckroot.sdk.logger;

import com.blckroot.sdk.logger.configurator.LogConfigurator;

import java.io.IOException;

import static java.lang.System.Logger.Level.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.initializeLogger();
        logConfigurator.setLevel(TRACE);

        System.Logger logger = System.getLogger(Main.class.getName());
        logger.log(TRACE, "trace log level test");
    }
}
