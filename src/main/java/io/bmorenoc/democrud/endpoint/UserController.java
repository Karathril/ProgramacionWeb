package io.bmorenoc.democrud.endpoint;

import io.bmorenoc.democrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor

public class UserController {
    final private UserService service;

    @GetMapping("/users")
    public ResponseEntity<GetUsersResponse> getUsers(){
        GetUsersResponse response = new GetUsersResponse();
        response.setUsers(service.getListUsers());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<GetUserResponse> getUsers(@PathVariable("id") int id){
        User userById = service.getUserById(id);
        if(userById != null){
            GetUserResponse response = new GetUserResponse();
            response.setUser(userById);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<PostUserResponse> post(@RequestBody User user){
        int id = service.addUser(user);
        PostUserResponse response = new PostUserResponse();
        response.setId(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable("id") int id) {
        User userById = service.getUserById(id);
        if (userById != null) {
            service.deleteUser(id);
            DeleteUserResponse response = new DeleteUserResponse();
            response.setDeletedUserId(id);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

