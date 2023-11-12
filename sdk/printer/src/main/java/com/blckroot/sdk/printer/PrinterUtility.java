package com.blckroot.sdk.printer;

import java.io.PrintStream;

class PrinterUtility implements PrinterContract {

    @Override
    public void print(PrintStream printStream, Object content) {
        printStream.println(content);
    }
}
