package ru.mtuci.volovodovskiy.exceptions;

public abstract class LicenseHistoryException extends RuntimeException {
    public LicenseHistoryException(String msg) {
        super(msg);
    }
    public LicenseHistoryException(String msg, Throwable cause) {
        super(msg, cause);
    }
}