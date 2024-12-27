package ru.mtuci.volovodovskiy.exceptions.categories;

import ru.mtuci.volovodovskiy.exceptions.ProductException;

public class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
    public ProductNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
