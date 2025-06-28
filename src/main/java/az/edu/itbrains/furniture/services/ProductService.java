package az.edu.itbrains.furniture.services;

import az.edu.itbrains.furniture.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
}
