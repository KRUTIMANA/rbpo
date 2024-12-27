package ru.mtuci.volovodovskiy.exceptions.categories;

import ru.mtuci.volovodovskiy.exceptions.AuthenticationException;

public class AuthenticationErrorException extends AuthenticationException {
    public AuthenticationErrorException(String msg) {
        super(msg);
    }
    public AuthenticationErrorException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
