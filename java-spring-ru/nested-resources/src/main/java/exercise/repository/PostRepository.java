package exercise.repository;

import exercise.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    boolean existsByTitle(String title);

    boolean existsById(long id);
}
