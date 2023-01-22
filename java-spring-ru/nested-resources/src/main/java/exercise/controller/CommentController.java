package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // BEGIN
    @GetMapping()
    public Iterable<Comment> getAllCommentsByPost(
            @PathVariable("postId") long postId) {
        checkPostExist(postId);
        return commentRepository.findCommentsByPostId(postId);
    }

    @GetMapping(path = "/{commentId}")
    public Comment getComment(
            @PathVariable("postId") long postId,
            @PathVariable("commentId") long commentId) {
        checkCommentExist(postId, commentId);
        return commentRepository.findCommentByIdAndPostId(commentId, postId);
    }

    @PostMapping()
    public void createComment(
            @PathVariable("postId") long postId,
            @RequestBody Comment comment) {
        checkPostExist(postId);
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @PatchMapping(path = "/{commentId}")
    public void updateComment(
            @PathVariable("postId") long postId,
            @PathVariable("commentId") long commentId,
            @RequestBody Comment comment) {
        checkPostExist(postId);
        Comment commentDB = commentRepository.findCommentByIdAndPostId(commentId, postId);
        commentDB.setContent(comment.getContent());

        commentRepository.save(commentDB);
    }

    @DeleteMapping(path = "/{commentId}")
    public void deleteComment(
            @PathVariable("postId") long postId,
            @PathVariable("commentId") long commentId) {
        checkCommentExist(postId, commentId);

        Comment comment = commentRepository.findCommentByIdAndPostId(postId, commentId);
        commentRepository.delete(comment);
    }




    private void checkPostExist(long postId) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("post is not found");

        }
    }

    private void checkCommentExist(long postId, long commentId) {
        if (!commentRepository.existsByIdAndPostId(commentId, postId)) {
            throw new ResourceNotFoundException("comment is not found");
        }
    }


    // END

//    Создайте полный CRUD для комментариев поста. Добавьте в контроллер методы, которые будут обрабатывать следующие запросы:
//
//    GET /posts/{postId}/comments - вывод всех комментариев для конкретного поста.
//    Должны выводится только комментарии, принадлежащие посту.
//            GET /posts/{postId}/comments/{commentId} - вывод конкретного комментария для поста.
//            Должны выводится только комментарий, принадлежащие посту.
//            Если такой комментарий не существует, должен вернуться ответ с кодом 404.
//    POST /posts/{postId}/comments - создание нового комментария для поста.
//    Должны выводится только комментарий, принадлежащие посту.
//            PATCH /posts/{postId}/comments/{commentId} - редактирование конкретного комментария поста.
//            Если такой комментарий не существует, должен вернуться ответ с кодом 404.
//    DELETE /posts/{postId}/comments/{commentId} - удаление конкретного комментария у поста. Е
//    сли такой комментарий не существует, должен вернуться ответ с кодом 404.
}
