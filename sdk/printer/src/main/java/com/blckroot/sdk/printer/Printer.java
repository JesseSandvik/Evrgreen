package com.blckroot.sdk.printer;

import java.io.PrintStream;

public class Printer implements PrinterContract {
    private final PrinterUtility printerUtility;

    public Printer() {
        this.printerUtility = new PrinterUtility();
    }

    @Override
    public void print(PrintStream printStream, Object content) {
        printerUtility.print(printStream, content);
    }
}
