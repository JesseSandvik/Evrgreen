package com.blckroot.evrgreen.services;

public class OperatingSystemService implements OperatingSystemServiceContract {
    private final OperatingSystemServiceUtility operatingSystemServiceUtility;

    public OperatingSystemService() {
        this.operatingSystemServiceUtility = new OperatingSystemServiceUtility();
    }

    @Override
    public String getFileSeparator() {
        return operatingSystemServiceUtility.getFileSeparator();
    }

    @Override
    public String getJavaClassPath() {
        return operatingSystemServiceUtility.getJavaClassPath();
    }

    @Override
    public String getJavaHome() {
        return operatingSystemServiceUtility.getJavaHome();
    }

    @Override
    public String getJavaVendor() {
        return operatingSystemServiceUtility.getJavaVendor();
    }

    @Override
    public String getJavaVendorUrl() {
        return operatingSystemServiceUtility.getJavaVendorUrl();
    }

    @Override
    public String getJavaVersion() {
        return operatingSystemServiceUtility.getJavaVersion();
    }

    @Override
    public String getLineSeparator() {
        return operatingSystemServiceUtility.getLineSeparator();
    }

    @Override
    public String getOSArchitecture() {
        return operatingSystemServiceUtility.getOSArchitecture();
    }

    @Override
    public String getOSName() {
        return operatingSystemServiceUtility.getOSName();
    }

    @Override
    public String getOSVersion() {
        return operatingSystemServiceUtility.getOSVersion();
    }

    @Override
    public String getPathSeparator() {
        return operatingSystemServiceUtility.getPathSeparator();
    }

    @Override
    public String getUserDirectory() {
        return operatingSystemServiceUtility.getUserDirectory();
    }

    @Override
    public String getUserHome() {
        return operatingSystemServiceUtility.getUserHome();
    }

    @Override
    public String getUserName() {
        return operatingSystemServiceUtility.getUserName();
    }
}
