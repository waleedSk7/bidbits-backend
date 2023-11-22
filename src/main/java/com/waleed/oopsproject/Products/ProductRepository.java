package com.waleed.oopsproject.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByCategory(String category);

    Optional<ProductModel> findByProductName(String productName);

    List<ProductModel> findByProductNameContaining(String productName);

    Optional<List<ProductModel>> findBySellerId(String sellerId);
}
