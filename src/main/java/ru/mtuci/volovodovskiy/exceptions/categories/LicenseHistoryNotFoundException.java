package ru.mtuci.volovodovskiy.exceptions.categories;

import ru.mtuci.volovodovskiy.exceptions.LicenseHistoryException;

public class LicenseHistoryNotFoundException extends LicenseHistoryException {
    public LicenseHistoryNotFoundException(String msg) {
        super(msg);
    }
    public LicenseHistoryNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
