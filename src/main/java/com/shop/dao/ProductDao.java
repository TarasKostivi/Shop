package com.shop.dao;

import com.shop.entity.Category;
import com.shop.entity.Product;

import java.util.List;

public interface ProductDao extends GeneralDao<Product> {

    List<Product> getFromCategory(Category category);

    Product getWithCategory(int id);

    List<Product> liveSearch(String search);

    List<Product> getListPrice(int price);

}
