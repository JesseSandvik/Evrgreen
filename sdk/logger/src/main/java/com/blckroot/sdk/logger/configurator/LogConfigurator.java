package com.blckroot.sdk.logger.configurator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class LogConfigurator {

    public void initializeLogger() {
        ConfigurationBuilder<BuiltConfiguration> configurationBuilder =
                ConfigurationBuilderFactory.newConfigurationBuilder();

        AppenderComponentBuilder console = configurationBuilder.newAppender("stdout", "Console");
        configurationBuilder.add(console);

        LayoutComponentBuilder standard = configurationBuilder.newLayout("PatternLayout");
        standard.addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable");

//        compact="true" eventEol="true" properties="true" stacktraceAsString="true" includeTimeMillis="true"
        LayoutComponentBuilder jsonLayout = configurationBuilder.newLayout("JsonLayout");
        jsonLayout.addAttribute("compact", "true");
        jsonLayout.addAttribute("eventEol", "true");
        jsonLayout.addAttribute("properties", "true");
        jsonLayout.addAttribute("stacktraceAsString", "true");
        jsonLayout.addAttribute("includeTimeMillis", "true");

//        AppenderComponentBuilder file = configurationBuilder.newAppender("log", "File");
//        file.add(standard);
//        file.addAttribute("fileName", "command/src/test/resources/test.log");
//        configurationBuilder.add(file);

        AppenderComponentBuilder rollingFile = configurationBuilder.newAppender("rolling", "RollingFile");
        rollingFile.add(jsonLayout);
        rollingFile.addAttribute("fileName", "command/src/test/resources/rolling-test.log");
        rollingFile.addAttribute("filePattern", "rolling-%d{MM-dd-yy}.log.gz");

        ComponentBuilder<?> triggeringPolicies = configurationBuilder.newComponent("Policies")
                .addComponent(configurationBuilder.newComponent("CronTriggeringPolicy")
                        .addAttribute("schedule", "0 0 0 * * ?"))
                .addComponent(configurationBuilder.newComponent("SizeBasedTriggeringPolicy")
                        .addAttribute("size", "100M"));

        rollingFile.addComponent(triggeringPolicies);
        configurationBuilder.add(rollingFile);

        RootLoggerComponentBuilder rootLogger = configurationBuilder.newRootLogger(Level.ERROR);
        rootLogger.add(configurationBuilder.newAppenderRef("rolling"));
//        rootLogger.add(configurationBuilder.newAppenderRef("stdout"));
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
