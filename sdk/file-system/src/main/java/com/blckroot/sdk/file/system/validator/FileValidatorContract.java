package com.blckroot.sdk.file.system.validator;

interface FileValidatorContract {
    Boolean directoryExists(String directory);
    Boolean fileCanExecute(String file);
    Boolean fileExists(String file);
}