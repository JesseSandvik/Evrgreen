package com.blckroot.sdk.file.system.executor;

import java.io.PrintStream;
import java.util.List;

interface FileExecutorContract {
    Integer executeProgramWithOutput(List<String> command, PrintStream outputStream);
}