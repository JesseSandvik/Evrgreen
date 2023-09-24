package com.evergreen.command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

            for (Map.Entry<String, Object> parameter : this.getValuesToPositionalParameterLabels().entrySet()) {
                args.add(parameter.getValue().toString());
            }

            for (Map.Entry<String, Object> option : this.getValuesToOptionsLongestName().entrySet()) {
                args.add(option.getKey());
                args.add(option.getValue().toString());
            }

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
