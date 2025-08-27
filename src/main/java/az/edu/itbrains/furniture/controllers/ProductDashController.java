package az.edu.itbrains.furniture.controllers;

import az.edu.itbrains.furniture.dtos.product.ProductCreateDto;
import az.edu.itbrains.furniture.dtos.product.ProductDashboardDto;
import az.edu.itbrains.furniture.dtos.product.ProductUpdateDto;
import az.edu.itbrains.furniture.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductDashController {
    private final ProductService productService;

    public ProductDashController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/admin/product")
    public  String getAll(Model model){
        List<ProductDashboardDto> productDashboardDtoList=productService.getProductAll();
        model.addAttribute("products",productDashboardDtoList);
        return "/dashboard/product/index";
    }
    @GetMapping("/admin/product/create")
    public  String create(Model model){
      model.addAttribute("product",new ProductCreateDto());
        return "/dashboard/product/create";
    }
    @PostMapping("/admin/product/create")
    public  String create(@ModelAttribute("product") ProductCreateDto productCreateDto){
        productService.createProduct(productCreateDto);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/update/{id}")
    public  String update(@PathVariable Long id ,Model model){
        ProductUpdateDto productUpdateDto=productService.getUpdateProduct(id);
        model.addAttribute("product",productUpdateDto);

        return "/dashboard/product/update";
    }
    @PostMapping("/admin/product/update/{id}")
    public  String update(@PathVariable Long id ,@ModelAttribute("product") ProductUpdateDto productUpdateDto){
       productService.updateProduct(id,productUpdateDto);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/delete/{id}")
    public  String delete(@PathVariable ("id") Long id){
        return "/dashboard/product/delete";
    }
    @PostMapping("/admin/product/delete/{id}")
    public  String deletes(@PathVariable ("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/admin/product";
    }
}
