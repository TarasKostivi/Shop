package com.shop.service;

import com.shop.entity.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    List<Category> getAll();

    Category getOne(int id);

    void delete(int id);

    void update(Category category);

    List<Category> getByName(String name);
}
