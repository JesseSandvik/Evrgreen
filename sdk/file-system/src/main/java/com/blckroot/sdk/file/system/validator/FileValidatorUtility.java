package com.blckroot.sdk.file.system.validator;

import java.io.File;

class FileValidatorUtility implements FileValidatorContract {

    @Override
    public Boolean fileCanExecute(String file) {
        if (file == null) {
            return false;
        }
        File potentialFile = new File(file);
        return potentialFile.canExecute() && potentialFile.isFile();
    }
}
