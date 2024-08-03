package com.example.shopApp.services;

import com.example.shopApp.dtos.ProductDTO;
import com.example.shopApp.dtos.ProductImageDTO;
import com.example.shopApp.exceptions.DataNotFoundException;
import com.example.shopApp.exceptions.InvalidParamsException;
import com.example.shopApp.models.Product;
import com.example.shopApp.models.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    Product createProduct(ProductDTO productDTO) throws DataNotFoundException;
    Page<Product> getAllProducts(PageRequest pageRequest);

    Product getProductById(long id) throws DataNotFoundException;

    Product updateProduct(Long id, ProductDTO productDTO) throws DataNotFoundException;

    void deleteProduct(Long id);

    boolean existsByName(String name);

    public ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws DataNotFoundException, InvalidParamsException;
}
