package com.blckroot.sdk.operating.system.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatingSystemServiceTest {

    @Test
    void OPERATING_SYSTEM_SERVICE__get_file_separator() {
        String expected = System.getProperty("file.separator");
        String actual = new OperatingSystemService().getFileSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_java_class_path() {
        String expected = System.getProperty("java.class.path");
        String actual = new OperatingSystemService().getJavaClassPath();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_java_home() {
        String expected = System.getProperty("java.home");
        String actual = new OperatingSystemService().getJavaHome();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_java_vendor() {
        String expected = System.getProperty("java.vendor");
        String actual = new OperatingSystemService().getJavaVendor();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_java_vendor_url() {
        String expected = System.getProperty("java.vendor.url");
        String actual = new OperatingSystemService().getJavaVendorUrl();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_java_version() {
        String expected = System.getProperty("java.version");
        String actual = new OperatingSystemService().getJavaVersion();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_line_separator() {
        String expected = System.getProperty("line.separator");
        String actual = new OperatingSystemService().getLineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_OS_architecture() {
        String expected = System.getProperty("os.arch");
        String actual = new OperatingSystemService().getOSArchitecture();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_OS_name() {
        String expected = System.getProperty("os.name");
        String actual = new OperatingSystemService().getOSName();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_OS_version() {
        String expected = System.getProperty("os.version");
        String actual = new OperatingSystemService().getOSVersion();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_path_separator() {
        String expected = System.getProperty("path.separator");
        String actual = new OperatingSystemService().getPathSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_user_directory() {
        String expected = System.getProperty("user.dir");
        String actual = new OperatingSystemService().getUserDirectory();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_user_home() {
        String expected = System.getProperty("user.home");
        String actual = new OperatingSystemService().getUserHome();
        assertEquals(expected, actual);
    }

    @Test
    void OPERATING_SYSTEM_SERVICE__get_user_name() {
        String expected = System.getProperty("user.name");
        String actual = new OperatingSystemService().getUserName();
        assertEquals(expected, actual);
    }
}
