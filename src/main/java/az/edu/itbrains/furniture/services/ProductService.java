package az.edu.itbrains.furniture.services;

import az.edu.itbrains.furniture.dtos.product.ProductCreateDto;
import az.edu.itbrains.furniture.dtos.product.ProductDashboardDto;
import az.edu.itbrains.furniture.dtos.product.ProductDto;
import az.edu.itbrains.furniture.dtos.product.ProductUpdateDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    List<ProductDashboardDto> getProductAll();

    void createProduct(ProductCreateDto productCreateDto);

    ProductUpdateDto getUpdateProduct(Long id);

    void updateProduct(Long id, ProductUpdateDto productUpdateDto);

    void deleteProduct(Long id);

    ProductDto getProductById(Long id);

}
