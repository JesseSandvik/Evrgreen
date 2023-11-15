package com.blckroot.sdk.logger.configurator;

import com.blckroot.sdk.operating.system.service.OperatingSystemService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class LogConfigurator {
    private final OperatingSystemService operatingSystemService = new OperatingSystemService();
    private final ConfigurationBuilder<BuiltConfiguration> builder;
    private final RootLoggerComponentBuilder rootLogger;
    private final String outputDirectory =
            operatingSystemService.getUserHome() + operatingSystemService.getFileSeparator() +
                    ".blckroot" + operatingSystemService.getFileSeparator();

    public LogConfigurator() {
        this.builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        this.rootLogger = builder.newRootLogger();
    }

    private LayoutComponentBuilder getStandardPatternLayout(ConfigurationBuilder<BuiltConfiguration> builder) {
        LayoutComponentBuilder standard = builder.newLayout("PatternLayout");
        standard.addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable");
        return standard;
    }

    private ComponentBuilder<?> getTriggeringPolicies(ConfigurationBuilder<BuiltConfiguration> builder) {
        ComponentBuilder<?> triggeringPolicies = builder.newComponent("Policies");
        triggeringPolicies
                .addComponent(builder.newComponent("CronTriggeringPolicy").addAttribute("schedule", "0 0 0 * * ?"))
                .addComponent(builder.newComponent("SizeBasedTriggeringPolicy")
                        .addAttribute("size", "1MB"));
        return triggeringPolicies;
    }

    private ComponentBuilder<?> getRolloverStrategy(ConfigurationBuilder<BuiltConfiguration> builder) {
        ComponentBuilder<?> rolloverStrategy = builder.newComponent("DefaultRolloverStrategy");
        rolloverStrategy.addAttribute("max", "1");
        return rolloverStrategy;
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
        file.addAttribute("fileName", outputDirectory + "blckroot.log");
        return file;
    }

    private AppenderComponentBuilder getRollingFileAppender(ConfigurationBuilder<BuiltConfiguration> builder) {
        AppenderComponentBuilder rollingFile = builder.newAppender("rolling", "RollingFile");
        rollingFile.addAttribute("fileName", outputDirectory + "blckroot.log");
        rollingFile.addAttribute("filePattern", "rolling-%d{MM-dd-yy}.log.gz");
        rollingFile.add(getStandardPatternLayout(builder));
        rollingFile.addComponent(getTriggeringPolicies(builder));
        rollingFile.addComponent(getRolloverStrategy(builder));
        return rollingFile;
    }

    public void initializeLogger() {
        rootLogger.addAttribute("additivity", "true");
        builder.add(rootLogger);
        org.apache.logging.log4j.core.config.Configurator.initialize(builder.build());
    }

//    Set configuration file path dynamically
//    public void initializeLogger(String configurationFilePath) {
//        org.apache.logging.log4j.core.config.Configurator.initialize(null, configurationFilePath);

    public void enableConsoleLogging(Boolean enable) {
        if (enable) {
            builder.add(getConsoleAppender(builder));
            rootLogger.add(builder.newAppenderRef("console"));
        }
    }
    public void enableFileSystemLogging(Boolean enable) {
        if (enable) {
            builder.add(getFileAppender(builder));
            rootLogger.add(builder.newAppenderRef("file"));
        }
    }
    public void enableRollingFileSystemLogging(Boolean enable) {
        if (enable) {
            builder.add(getRollingFileAppender(builder));
            rootLogger.add(builder.newAppenderRef("rolling"));
        }
    }

    public void setLevel(System.Logger.Level level) {
        org.apache.logging.log4j.core.config.Configurator.setLevel(LogManager.getRootLogger(), Level.valueOf(level.getName()));
    }
}
