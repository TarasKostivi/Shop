package com.shop.dao;

import com.shop.entity.Category;

import java.util.List;

public interface CategoryDao extends GeneralDao<Category> {

    List<Category> getByName(String name);

    Category getWithProducts(int id);

}
