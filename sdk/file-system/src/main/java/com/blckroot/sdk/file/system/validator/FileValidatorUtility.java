package com.blckroot.sdk.file.system.validator;

import java.io.File;

class FileValidatorUtility implements FileValidatorContract {

    @Override
    public Boolean directoryExists(String directory) {
        return new File(directory).isDirectory();
    }

    @Override
    public Boolean fileCanExecute(String file) {
        if (file == null) {
            return false;
        }
        File potentialExecutableFile = new File(file);
        return potentialExecutableFile.canExecute() && potentialExecutableFile.isFile();
    }

    @Override
    public Boolean fileExists(String file) {
        return new File(file).isFile();
    }
}
