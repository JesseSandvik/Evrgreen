package com.blckroot.sdk.file.system.executor;

import java.io.PrintStream;
import java.util.List;

public class FileExecutor implements FileExecutorContract {
    private final FileExecutorUtility executorUtility;

    public FileExecutor() {
        this.executorUtility = new FileExecutorUtility();
    }

    @Override
    public Integer executeProgramWithOutput(List<String> command, PrintStream outputStream) {
        return executorUtility.executeProgramWithOutput(command, outputStream);
    }
}
