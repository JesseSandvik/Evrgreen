module com.blckroot.sdk.logger {
    requires org.apache.logging.log4j.plugins;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires blckroot.sdk.operating.system;

    provides System.LoggerFinder
            with com.blckroot.sdk.logger.LoggerFinder;
    exports com.blckroot.sdk.logger.configurator;
    exports com.blckroot.sdk.logger;
}