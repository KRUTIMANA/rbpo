package ru.mtuci.volovodovskiy.repository;

import ru.mtuci.volovodovskiy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}