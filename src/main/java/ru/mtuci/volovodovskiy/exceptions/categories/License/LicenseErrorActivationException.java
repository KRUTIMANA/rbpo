package ru.mtuci.volovodovskiy.exceptions.categories.License;

import ru.mtuci.volovodovskiy.exceptions.LicenseException;

public class LicenseErrorActivationException extends LicenseException {
    public LicenseErrorActivationException(String msg) {
        super(msg);
    }
    public LicenseErrorActivationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
