package ru.mtuci.volovodovskiy.exceptions.categories;

import ru.mtuci.volovodovskiy.exceptions.LicenseTypeException;

public class LicenseTypeNotFoundException extends LicenseTypeException {
    public LicenseTypeNotFoundException(String msg) {
        super(msg);
    }
    public LicenseTypeNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
