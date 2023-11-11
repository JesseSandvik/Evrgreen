package com.blckroot.sdk.file.system.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileValidatorTest {

    // **** File Can Execute **************************************************************************************** //

    @Test
    void FILE_VALIDATOR__file_can_execute__null() {
        boolean expected = false;
        FileValidator fileValidator = new FileValidator();
        boolean actual = fileValidator.fileCanExecute(null);
        assertEquals(expected, actual);
    }

    @Test
    void FILE_VALIDATOR__file_can_execute__empty() {
        boolean expected = false;
        FileValidator fileValidator = new FileValidator();
        boolean actual = fileValidator.fileCanExecute("");
        assertEquals(expected, actual);
    }

    @Test
    void FILE_VALIDATOR__file_can_execute__blank() {
        boolean expected = false;
        FileValidator fileValidator = new FileValidator();
        boolean actual = fileValidator.fileCanExecute("    ");
        assertEquals(expected, actual);
    }

    @Test
    void FILE_VALIDATOR__file_can_execute__directory() {
        boolean expected = false;
        FileValidator fileValidator = new FileValidator();
        boolean actual = fileValidator.fileCanExecute("src/test/resources/");
        assertEquals(expected, actual);
    }

    @Test
    void FILE_VALIDATOR__file_can_execute__can_not_execute() {
        boolean expected = false;
        FileValidator fileValidator = new FileValidator();
        boolean actual = fileValidator.fileCanExecute("src/test/resources/bad-file");
        assertEquals(expected, actual);
    }

    @Test
    void FILE_VALIDATOR__file_can_execute__can_execute() {
        boolean expected = true;
        FileValidator fileValidator = new FileValidator();
        boolean actual = fileValidator.fileCanExecute("src/test/resources/test-file");
        assertEquals(expected, actual);
    }
}
