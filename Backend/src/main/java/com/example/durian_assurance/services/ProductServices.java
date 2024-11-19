package com.example.durian_assurance.services;

import com.example.durian_assurance.dto.requests.CreateProductRequest;
import com.example.durian_assurance.iservices.IProductService;
import com.example.durian_assurance.models.Product;
import com.example.durian_assurance.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class ProductServices implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product creatProduct(CreateProductRequest productDTO) {
        Product newProduct = Product
                .builder()
                .name(productDTO.getName())
                .productDescription(productDTO.getProductDescription())
                .productCategory(productDTO.getProductCategory())
                .startDate(productDTO.getStartDate())
                .endDate(productDTO.getEndDate())
                .paymentAmount(productDTO.getPaymentAmount())
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public Product updateProduct(Long id, CreateProductRequest productDTO) {
        Product existingProduct = getProductById(id);

        if (existingProduct != null) {
            existingProduct.setName(productDTO.getName());
            existingProduct.setPaymentAmount(productDTO.getPaymentAmount());
            existingProduct.setProductCategory(productDTO.getProductCategory());
            existingProduct.setProductDescription(productDTO.getProductDescription());
            existingProduct.setStartDate(productDTO.getStartDate());
            existingProduct.setEndDate(productDTO.getEndDate());
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}


