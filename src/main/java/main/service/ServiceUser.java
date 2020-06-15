package main.service;


import main.model.User;

import java.util.Optional;

public interface ServiceUser {

    User save(User s);

    Optional<User> findById(Long id);

    Iterable<User> findAll();

    void deleteById(Long aLong);

    User findByName(String name);
}
