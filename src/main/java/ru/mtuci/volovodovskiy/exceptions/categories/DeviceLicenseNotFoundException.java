package ru.mtuci.volovodovskiy.exceptions.categories;

import ru.mtuci.volovodovskiy.exceptions.DeviceLicenseException;

public class DeviceLicenseNotFoundException extends DeviceLicenseException {
    public DeviceLicenseNotFoundException(String msg) { super(msg); }
    public DeviceLicenseNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
