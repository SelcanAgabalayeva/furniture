package az.edu.itbrains.furniture.services.Impls;

import az.edu.itbrains.furniture.dtos.ProductDto;
import az.edu.itbrains.furniture.models.Product;
import az.edu.itbrains.furniture.repositories.ProductRepository;
import az.edu.itbrains.furniture.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList=productRepository.findAll();
        List<ProductDto>productDtoList=productList.stream().map(pro->modelMapper.map(pro, ProductDto.class)).collect(Collectors.toList());
        return productDtoList;
    }
}
