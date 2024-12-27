package ru.mtuci.volovodovskiy.exceptions.categories.License;

import ru.mtuci.volovodovskiy.exceptions.LicenseException;

public class LicenseNotFoundException extends LicenseException {
    public LicenseNotFoundException(String msg) {
        super(msg);
    }
    public LicenseNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
