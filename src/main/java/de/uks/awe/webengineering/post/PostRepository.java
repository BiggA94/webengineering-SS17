package de.uks.awe.webengineering.post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexw on 08.05.2017.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> getAllByIdNotNullOrderByTimeOfCreation();
}
