package ru.mtuci.volovodovskiy.exceptions;

public abstract class LicenseException extends RuntimeException {
    public LicenseException(String msg) {
        super(msg);
    }
    public LicenseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}