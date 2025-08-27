package az.edu.itbrains.furniture.services.Impls;

import az.edu.itbrains.furniture.dtos.product.ProductCreateDto;
import az.edu.itbrains.furniture.dtos.product.ProductDashboardDto;
import az.edu.itbrains.furniture.dtos.product.ProductDto;
import az.edu.itbrains.furniture.dtos.product.ProductUpdateDto;
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

    @Override
    public List<ProductDashboardDto> getProductAll() {
        List<ProductDashboardDto> productDashboardDtoList=productRepository.findAll().stream().map(products->modelMapper.map(products, ProductDashboardDto.class)).collect(Collectors.toList());
        return productDashboardDtoList;
    }

    @Override
    public void createProduct(ProductCreateDto productCreateDto) {
        Product product=new Product();
        product.setName(productCreateDto.getName());
        product.setPhotoUrl(productCreateDto.getPhotoUrl());
        product.setPrice(productCreateDto.getPrice());
        productRepository.save(product);
    }

    @Override
    public ProductUpdateDto getUpdateProduct(Long id) {
        Product product=productRepository.findById(id).orElseThrow();
        ProductUpdateDto dto =new ProductUpdateDto();
        dto.setName(product.getName());
        dto.setPhotoUrl(product.getPhotoUrl());
        dto.setPrice(product.getPrice());
        return dto;
    }

    @Override
    public void updateProduct(Long id, ProductUpdateDto productUpdateDto) {
        Product product=productRepository.findById(id).orElseThrow();

        product.setName(productUpdateDto.getName());
        product.setPhotoUrl(productUpdateDto.getPhotoUrl());
        product.setPrice(productUpdateDto.getPrice());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product findProduct=productRepository.findById(id).orElseThrow();
        productRepository.delete(findProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product=productRepository.findById(id).orElseThrow();
        return modelMapper.map(product,ProductDto.class);
    }
}
