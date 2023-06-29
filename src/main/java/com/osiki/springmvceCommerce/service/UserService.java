package com.osiki.springmvceCommerce.service;

import com.osiki.springmvceCommerce.model.UserModel;

public interface UserService {

    UserModel registerUser(String login, String email, String password);
    UserModel authenticate(String login, String password);
}
