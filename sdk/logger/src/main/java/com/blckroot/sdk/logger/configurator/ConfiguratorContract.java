package com.blckroot.sdk.logger.configurator;

interface ConfiguratorContract {
    void initializeLogger();
    void setLevel(System.Logger.Level level);
}
