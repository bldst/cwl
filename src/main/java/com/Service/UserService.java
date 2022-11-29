package com.Service;

import com.User.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User get(Integer id);

    User getByAccount(String account);
    void updateTokenUser(User user);

    String Register(User user);
    String login(User user);
    String CheckToken(HttpServletRequest request);
}
