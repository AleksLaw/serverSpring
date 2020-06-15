package main.repository;


import org.springframework.data.repository.CrudRepository;
import main.model.User;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByName(String name);
    Optional<User> findById(Long id);
}
