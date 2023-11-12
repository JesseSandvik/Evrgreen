package com.blckroot.sdk.file.system.service;

import java.io.*;
import java.util.List;
import java.util.Properties;

class FileSystemServiceUtility implements FileSystemServiceContract {

    @Override
    public Properties getPropertiesFromFile(String propertiesFile) {
        try (InputStream inputStream = new FileInputStream(propertiesFile)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer executeExternalProgram(PrintStream printStream, List<String> arguments) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(arguments);
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printStream.println(line);
            }

            process.waitFor();
            return process.exitValue();
        } catch (RuntimeException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
