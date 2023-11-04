package com.blckroot.evrgreen.services;

import java.util.Properties;

public class OperatingSystemServiceUtility implements OperatingSystemServiceContract {
    private static Properties operatingSystemProperties;

    public OperatingSystemServiceUtility() {
        operatingSystemProperties = System.getProperties();
    }

    @Override
    public String getFileSeparator() {
        return operatingSystemProperties.getProperty("file.separator");
    }

    @Override
    public String getJavaClassPath() {
        return operatingSystemProperties.getProperty("java.class.path");
    }

    @Override
    public String getJavaHome() {
        return operatingSystemProperties.getProperty("java.home");
    }

    @Override
    public String getJavaVendor() {
        return operatingSystemProperties.getProperty("java.vendor");
    }

    @Override
    public String getJavaVendorUrl() {
        return operatingSystemProperties.getProperty("java.vendor.url");
    }

    @Override
    public String getJavaVersion() {
        return operatingSystemProperties.getProperty("java.version");
    }

    @Override
    public String getLineSeparator() {
        return operatingSystemProperties.getProperty("line.separator");
    }

    @Override
    public String getOSArchitecture() {
        return operatingSystemProperties.getProperty("os.arch");
    }

    @Override
    public String getOSName() {
        return operatingSystemProperties.getProperty("os.name");
    }

    @Override
    public String getOSVersion() {
        return operatingSystemProperties.getProperty("os.version");
    }

    @Override
    public String getPathSeparator() {
        return operatingSystemProperties.getProperty("path.separator");
    }

    @Override
    public String getUserDirectory() {
        return operatingSystemProperties.getProperty("user.dir");
    }

    @Override
    public String getUserHome() {
        return operatingSystemProperties.getProperty("user.home");
    }

    @Override
    public String getUserName() {
        return operatingSystemProperties.getProperty("user.name");
    }
}
