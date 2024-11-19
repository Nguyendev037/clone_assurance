package com.example.Durian_Assurance.controllers;


import com.example.Durian_Assurance.iservices.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;gui
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
//
//    @GetMapping("")
//    public Product getAllProduct




}
