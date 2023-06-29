package com.osiki.springmvceCommerce.service.impl;

import com.osiki.springmvceCommerce.model.UserModel;
import com.osiki.springmvceCommerce.repository.UserRepository;
import com.osiki.springmvceCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserModel registerUser(String login, String email, String password) {

        if (email == null || password == null) {
            return null;
        } else {
            UserModel userModel = new UserModel();
           userModel.setLogin(login);
            userModel.setEmail(email);
            userModel.setPassword(password);

            return userRepository.save(userModel);

        }
    }

    @Override
    public UserModel authenticate(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
