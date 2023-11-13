package com.blckroot.sdk.logger.configurator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class Configurator implements ConfiguratorContract {

    public void initialize(String configurationFilePath) {
        org.apache.logging.log4j.core.config.Configurator.initialize(null, configurationFilePath);
    }

    public void setLevel(System.Logger.Level level) {
        org.apache.logging.log4j.core.config.Configurator.setLevel(LogManager.getRootLogger(), Level.valueOf(level.getName()));
    }
}
