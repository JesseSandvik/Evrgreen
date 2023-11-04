package com.blckroot.evrgreen.services;

interface OperatingSystemServiceContract {
    String getFileSeparator();
    String getJavaClassPath();
    String getJavaHome();
    String getJavaVendor();
    String getJavaVendorUrl();
    String getJavaVersion();
    String getLineSeparator();
    String getOSArchitecture();
    String getOSName();
    String getOSVersion();
    String getPathSeparator();
    String getUserDirectory();
    String getUserHome();
    String getUserName();
}
