package com.blckroot.sdk.file.system.validator;

public class FileValidator implements FileValidatorContract {
    private final FileValidatorUtility fileValidatorUtility;

    public FileValidator() {
        this.fileValidatorUtility = new FileValidatorUtility();
    }

    @Override
    public Boolean directoryExists(String directory) {
        return fileValidatorUtility.directoryExists(directory);
    }

    @Override
    public Boolean fileCanExecute(String file) {
        return fileValidatorUtility.fileCanExecute(file);
    }

    @Override
    public Boolean fileExists(String file) {
        return fileValidatorUtility.fileExists(file);
    }
}
