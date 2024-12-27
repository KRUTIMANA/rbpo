package ru.mtuci.volovodovskiy.exceptions.categories;

import ru.mtuci.volovodovskiy.exceptions.UserException;

public class UserNotFoundException extends UserException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
    public UserNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
