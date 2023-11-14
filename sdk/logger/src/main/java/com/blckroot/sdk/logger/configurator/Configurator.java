package com.blckroot.sdk.logger.configurator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class Configurator implements ConfiguratorContract {

    public void initializeLogger() {
        ConfigurationBuilder<BuiltConfiguration> configurationBuilder =
                ConfigurationBuilderFactory.newConfigurationBuilder();

//        AppenderComponentBuilder console = configurationBuilder.newAppender("stdout", "Console");
//        configurationBuilder.add(console);

        LayoutComponentBuilder standard = configurationBuilder.newLayout("PatternLayout");
        standard.addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable");

        AppenderComponentBuilder file = configurationBuilder.newAppender("log", "File");
        file.add(standard);
        file.addAttribute("fileName", "command/src/test/resources/test.log");
        configurationBuilder.add(file);

        RootLoggerComponentBuilder rootLogger = configurationBuilder.newRootLogger(Level.ERROR);
        rootLogger.add(configurationBuilder.newAppenderRef("log"));
        rootLogger.addAttribute("additivity", "true");
        configurationBuilder.add(rootLogger);
        org.apache.logging.log4j.core.config.Configurator.initialize(configurationBuilder.build());
    }

//    Set configuration file path dynamically
//    public void initializeLogger(String configurationFilePath) {
//        org.apache.logging.log4j.core.config.Configurator.initialize(null, configurationFilePath);
//    }

    public void setLevel(System.Logger.Level level) {
        org.apache.logging.log4j.core.config.Configurator.setLevel(LogManager.getRootLogger(), Level.valueOf(level.getName()));
    }
}
