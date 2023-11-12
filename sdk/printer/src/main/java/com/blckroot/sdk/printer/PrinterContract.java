package com.blckroot.sdk.printer;

import java.io.PrintStream;

interface PrinterContract {
    void print(PrintStream printStream, Object content);
}
