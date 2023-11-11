package com.blckroot.sdk.logger.service;

interface LoggerServiceContract {
    void setLogLevel(String level);
    void fatal(String message);
    void error(String message);
    void warn(String message);
    void info(String message);
    void debug(String message);
    void trace(String message);
}
