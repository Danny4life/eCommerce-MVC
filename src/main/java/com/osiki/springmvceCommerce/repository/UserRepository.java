package com.osiki.springmvceCommerce.repository;

import com.osiki.springmvceCommerce.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByLoginAndPassword(String login, String password);
}
