package ru.mtuci.volovodovskiy.exceptions.categories;

import ru.mtuci.volovodovskiy.exceptions.DeviceException;

public class DeviceNotFoundException extends DeviceException {
    public DeviceNotFoundException(String msg) { super(msg); }
    public DeviceNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
