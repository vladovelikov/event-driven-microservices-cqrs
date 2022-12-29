package com.microservices.ProductService.query.api.projection;

import com.microservices.ProductService.command.api.data.Product;
import com.microservices.ProductService.command.api.model.ProductRestModel;
import com.microservices.ProductService.command.api.repository.ProductRepository;
import com.microservices.ProductService.query.api.queries.GetProductsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    @Autowired
    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<Product> products = this.productRepository.findAll();
        List<ProductRestModel> productRestModels = products
                .stream()
                .map(product -> ProductRestModel
                        .builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build()
                        ).collect(Collectors.toList());

        return productRestModels;
    }
}
