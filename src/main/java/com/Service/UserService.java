package com.Service;

import com.User.User;

public interface UserService {
    User get(Integer id);

    User getByAccount(String account);

    String Register(User user);
    Integer login(User user);
}
