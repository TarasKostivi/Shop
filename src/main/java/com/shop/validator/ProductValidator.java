package com.shop.validator;

import com.shop.dao.UserDao;
import com.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductValidator implements Validator {

    @Autowired
    private UserDao userDao;

    public void  validate(Object... objects) throws Exception {
        Product product = (Product) objects[0];

        if (product.getName().isEmpty()) {
            throw new ValidationException(ValidationMessages.EMPTY_NAME_FIELD);
        } else if (product.getPrice() <=0) {
            throw new ValidationException(ValidationMessages.PRICE_MUST_BE_GREATER_THAN_ZERO);
        } else if (product.getDescription().isEmpty()) {
            throw new ValidationException(ValidationMessages.EMPTY_DESCRIPTION_FIELD);
        }
    }
}
