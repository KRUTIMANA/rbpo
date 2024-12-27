package ru.mtuci.volovodovskiy.service;


import ru.mtuci.volovodovskiy.model.Product;
import ru.mtuci.volovodovskiy.request.DataProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(Long id);

    // save
    Product save(DataProductRequest request);

    // read
    List<Product> getAll();

    // update
    Product update(DataProductRequest request);

    // delete
    void delete(Long id);
}
