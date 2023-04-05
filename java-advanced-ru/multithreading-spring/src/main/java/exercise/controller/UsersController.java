package exercise.controller;

import exercise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import exercise.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public Flux<User> getUsers() {
        return userService.findAll();
    }

    // BEGIN
    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable("id") long id) {
        return userService.findById(id);
    }


    @PostMapping()
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PatchMapping("/{id}")
    public Mono<User> updateUser(@PathVariable("id") long id,
                                 @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserById(@PathVariable("id") long id) {
        return userService.deleteUserById(id);
    }
    // END
}
