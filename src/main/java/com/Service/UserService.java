package com.Service;

import com.User.User;
import com.User.joinMatch;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {
    User get(Integer id);

    User getByAccount(String account);
    void updateTokenUser(User user);

    String Register(User user);
    Map login(User user);
    String CheckToken(HttpServletRequest request);
    void LogoutUser(String token);
    void updatePsd(User user);
    void joinMatch(joinMatch joinMatch);
}
