package exercise.repository;

import exercise.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    // BEGIN
    Iterable<Comment> findCommentsByPostId(Long id);
    Comment findCommentByIdAndPostId(long id, long postId);

    boolean existsByIdAndPostId(long id, long postId);
    // END
}
