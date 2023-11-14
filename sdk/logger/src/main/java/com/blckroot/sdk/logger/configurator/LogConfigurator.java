package com.blckroot.sdk.logger.configurator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import java.io.IOException;

public class LogConfigurator {
    private ConfigurationBuilder<BuiltConfiguration> builder;

    private LayoutComponentBuilder getStandardPatternLayout(ConfigurationBuilder<BuiltConfiguration> builder) {
        LayoutComponentBuilder standard = builder.newLayout("PatternLayout");
        standard.addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable");
        return standard;
    }

//    private LayoutComponentBuilder getJSONPatternLayout(ConfigurationBuilder<BuiltConfiguration> builder) {}

    private ComponentBuilder<?> getTriggeringPolicies(ConfigurationBuilder<BuiltConfiguration> builder) {
        ComponentBuilder<?> triggeringPolicies = builder.newComponent("Policies");
        triggeringPolicies
                .addComponent(builder.newComponent("CronTriggeringPolicy").addAttribute("schedule", "0 0 0 * * ?"))
                .addComponent(builder.newComponent("SizeBasedTriggeringPolicy")
                        .addAttribute("size", "100M"));
        return triggeringPolicies;
    }

    private AppenderComponentBuilder getConsoleAppender(ConfigurationBuilder<BuiltConfiguration> builder) {
        AppenderComponentBuilder console = builder.newAppender("console", "Console");
        console.add(getStandardPatternLayout(builder));

        console.addAttribute("target", "SYSTEM_OUT");
        return console;
    }

    private AppenderComponentBuilder getFileAppender(ConfigurationBuilder<BuiltConfiguration> builder) {
        AppenderComponentBuilder file = builder.newAppender("file", "File");
        file.add(getStandardPatternLayout(builder));

        file.addAttribute("fileName", "command/src/test/resources/test.log");
        return file;
    }

    private AppenderComponentBuilder getRollingFileAppender(ConfigurationBuilder<BuiltConfiguration> builder) {
        AppenderComponentBuilder rollingFile = builder.newAppender("rolling", "RollingFile");
        rollingFile.addAttribute("fileName", "logger/src/test/resources/rolling-test.log");
        rollingFile.addAttribute("filePattern", "rolling-%d{MM-dd-yy}.log.gz");

        rollingFile.add(getStandardPatternLayout(builder));
        rollingFile.addComponent(getTriggeringPolicies(builder));
        return rollingFile;
    }

    public void initializeLogger() throws IOException {
        builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        builder.add(getConsoleAppender(builder));
        builder.add(getFileAppender(builder));
        builder.add(getRollingFileAppender(builder));
//
////        compact="true" eventEol="true" properties="true" stacktraceAsString="true" includeTimeMillis="true"
//        LayoutComponentBuilder jsonLayout = configurationBuilder.newLayout("JsonLayout");
////        jsonLayout.addAttribute("compact", "true");
////        jsonLayout.addAttribute("eventEol", "true");
////        jsonLayout.addAttribute("properties", "true");
////        jsonLayout.addAttribute("stacktraceAsString", "true");
////        jsonLayout.addAttribute("includeTimeMillis", "true");
        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.ERROR);
        rootLogger.add(builder.newAppenderRef("console"));
        rootLogger.addAttribute("additivity", "true");
        builder.add(rootLogger);
        System.out.println("\n");
        builder.writeXmlConfiguration(System.out);
        System.out.println("\n");
        org.apache.logging.log4j.core.config.Configurator.initialize(builder.build());
    }

//    Set configuration file path dynamically
//    public void initializeLogger(String configurationFilePath) {
//        org.apache.logging.log4j.core.config.Configurator.initialize(null, configurationFilePath);

    public void enableConsoleLogging(Boolean enable) {
        if (enable) {
            builder.add(getConsoleAppender(builder));
        }
    }
    public void enableFileSystemLogging(Boolean enable) {
        if (enable) {
            builder.add(getFileAppender(builder));
        }
    }
    public void enableRollingFileSystemLogging(Boolean enable) {
        if (enable) {
            builder.add(getRollingFileAppender(builder));
        }
    }

    public void setLevel(System.Logger.Level level) {
        org.apache.logging.log4j.core.config.Configurator.setLevel(LogManager.getRootLogger(), Level.valueOf(level.getName()));
    }
}
