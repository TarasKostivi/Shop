package com.shop.dao;

import com.shop.entity.Role;
import com.shop.entity.User;

import java.util.List;

public interface UserDao extends GeneralDao<User> {

    User getByEmail(String email);

    User getByUUID(String uuid);

    List<User> getWithRole(Role role);

}
