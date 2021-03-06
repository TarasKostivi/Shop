package com.shop.daoImpl;

import com.shop.dao.UserDao;
import com.shop.entity.Product;
import com.shop.entity.Role;
import com.shop.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl extends GeneralDaoImpl<User> implements UserDao {

    public UserDaoImpl(){
        super(User.class);
    }

    @PersistenceContext(unitName="Primary")
    private EntityManager entityManager;

    public User getByEmail(String email) {
        return (User) entityManager.createQuery
                ("select u from User u where u.email = :email")
                .setParameter("email", email).getSingleResult();
    }

    @Transactional
    public User getByUUID(String uuid) {
        return (User) entityManager.createQuery
                ("select u from User u where u.uuid = :uuid")
                .setParameter("uuid", uuid).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getWithRole(Role role) {
        return (List<User>) entityManager.createQuery
                ("select u from User u where u.role = :role")
                .setParameter("role", role).getResultList();
    }
}
