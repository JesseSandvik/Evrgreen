package com.evergreen.command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExternalExecutableCommand extends ExecutableCommand {
    public ExternalExecutableCommand(String name) {
        super(name);
    }

    public ExternalExecutableCommand(String name, String version) {
        super(name, version);
    }

    @Override
    public Integer call() throws IOException, InterruptedException {
        String executableSubcommandFilePath = "./" + this.getName();
        File executableFile = new File(executableSubcommandFilePath);

        if (executableFile.exists()) {
            List<String> args = new ArrayList<>();
            args.add(executableSubcommandFilePath);

            final ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(args);
            final Process process = processBuilder.start();

            final InputStream inputStream = process.getInputStream();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String externalExecutablePrintedOutputLine;
            while ((externalExecutablePrintedOutputLine = bufferedReader.readLine()) != null) {
                System.out.println(externalExecutablePrintedOutputLine);
            }

            process.waitFor();
            return process.exitValue();
        }
        return 0;
    }
}
