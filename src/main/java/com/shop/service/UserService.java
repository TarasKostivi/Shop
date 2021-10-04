package com.shop.service;

import com.shop.entity.Role;
import com.shop.entity.User;

import java.util.List;

public interface UserService {

    void save(User user, String confirmPass) throws Exception;

    List<User> getAll();

    User getOne(int id);

    void delete(int id);

    void update(User user);

    User getByEmail(String email);

    void changeRole(int id);

    void changeEnabled(int id);

    User getByUUID(String uuid);

    List<User> getWithRole(Role role);

    void setUUID(User user, String uuid);

    void setEnabled(String uuid);
}
