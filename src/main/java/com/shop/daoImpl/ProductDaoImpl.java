package com.shop.daoImpl;

import com.shop.dao.ProductDao;
import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDaoImpl extends GeneralDaoImpl<Product> implements ProductDao {

    public ProductDaoImpl(Class<User> userClass){
        super(Product.class);
    }

    @PersistenceContext(unitName="Primary")
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> getFromCategory(Category category) {
        return (List<Product>) entityManager.createQuery
                ("select distinct p from Product p left join fetch p.category where p.category = :category order by p.id desc")
                .setParameter("category", category).getResultList();
    }

    @Transactional
    public Product getWithCategory(int id) {
        return (Product) entityManager.createQuery
                ("select distinct p from Product p left join fetch p.category where p.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> liveSearch(String search) {
        return (List<Product>) entityManager.createQuery
                ("select p from Product p where p.name like concat('%', :search, '%') order by p.id desc")
                .setParameter("search", search).getResultList();
    }

    @Transactional
    public List<Product> getByPrice(int price) {
        return (List<Product>) entityManager.createQuery
                ("select p from Product p where p.price <= :price order by p.id desc")
                .setParameter("price", price).getResultList();
    }

}
