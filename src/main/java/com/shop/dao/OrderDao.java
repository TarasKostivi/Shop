package com.shop.dao;

import com.shop.entity.Order;
import com.shop.entity.User;

import java.util.List;

public interface OrderDao extends GeneralDao<Order>{

    Order getNotPaidByUser(User user);

    List<Order> getByUser(User user);

}
