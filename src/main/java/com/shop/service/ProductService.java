package com.shop.service;

import com.shop.entity.Category;
import com.shop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {

    void save(Product product, int categoryId, MultipartFile multipartFile) throws Exception;

    List<Product> getAll();

    Product getOne(int id);

    void delete(int id);

    void update(Product product);

    List<Product> getFromCategory(Category category);

    Product getWithCategory(int id);

    List<Product> liveSearch(String search);

    List<Product> getByPrice(int price);

    int[] getPriceLimit();

    void changeImage(Product product,MultipartFile multipartFile) throws Exception;

    void validation(Product product) throws Exception;

    void addToCart(int userId, int productId);

    void setCategory(Product product, int categoryId);

    void setSameImage(int id, Product product);
}
