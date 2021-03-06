package com.shop.daoImpl;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CategoryDaoImpl extends GeneralDaoImpl<Category> implements CategoryDao {

    public CategoryDaoImpl() {
        super(Category.class);
    }

    @PersistenceContext(unitName = "Primary")
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Category> getByName(String name) {
        return (List<Category>) entityManager.createQuery
                ("select c from Category c where c.name like concat('%',:name,'%')")
                .setParameter("name", name).getResultList();
    }

    public Category getWithProducts(int id) {
        return (Category) entityManager.createQuery
                ("select distinct c from Category c left join fetch c.products where c.id = :id")
                .setParameter("id", id).getSingleResult();
    }
}
