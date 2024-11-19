package com.example.durian_assurance.iservices;

import com.example.durian_assurance.dto.requests.CreateProductRequest;
import com.example.durian_assurance.models.Product;

public interface IProductService {

    Product creatProduct(CreateProductRequest product);
    Product getProductById(Long productId);
    Product updateProduct(Long id, CreateProductRequest product);

    void deleteProduct(Long id);


}
