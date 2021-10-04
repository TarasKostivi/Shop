package com.shop.dto;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;
import com.shop.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class DtoUtilMapper {

    public static List<CategoryDto> categoriesToCategoriesDTO(List<Category> categories) {

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category : categories) {

            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setName(category.getName());

            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    public static List<ProductDto> productsToProductsDTO(List<Product> products) {

        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {

            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            productDto.setImage(product.getImage());

            productDtos.add(productDto);

        }
        return productDtos;
    }
}
