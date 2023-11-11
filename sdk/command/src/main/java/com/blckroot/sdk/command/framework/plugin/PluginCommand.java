package com.blckroot.sdk.command.framework.plugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PluginCommand {
    private String executableFilePath;

//    public PluginCommand(String name) {
//        super(name);
//    }

    public String getExecutableFilePath() {
        return executableFilePath;
    }

    public void setExecutableFilePath(String executableFilePath) {
        this.executableFilePath = executableFilePath;
    }

//    @Override
//    public Integer call() {
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder();
//            processBuilder.command(arguments);
//            Process process = processBuilder.start();
//
//            InputStream inputStream = process.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            process.waitFor();
//            return process.exitValue();
//
//        } catch (RuntimeException | InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
