package de.uks.awe.webengineering.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alexw on 16.05.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmailAndAndPassword(String email, String password);
}
