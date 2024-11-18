package com.example.Durian_Assurance.iservices;

import com.example.Durian_Assurance.dto.requests.CreateProductRequest;
import com.example.Durian_Assurance.models.Product;

public interface IProductService {

    Product creatProduct(CreateProductRequest product);
    Product getProductById(Long productId);
    Product updateProduct(Long id, CreateProductRequest product);

    void deleteProduct(Long id);


}
