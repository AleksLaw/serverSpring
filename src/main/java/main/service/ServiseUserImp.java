package main.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.model.User;
import main.repository.UserRepo;

import java.util.Optional;

@Service
public class ServiseUserImp implements ServiceUser {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User s) {
        return userRepo.save(s);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByName(name);
    }



}
