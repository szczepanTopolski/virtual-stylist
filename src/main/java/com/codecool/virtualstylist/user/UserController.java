package com.codecool.virtualstylist.user;

import com.codecool.virtualstylist.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserData(@PathVariable("id") int userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping
    public ResponseEntity editUser(@RequestBody UserForUpdateDTO userForUpdateDTO){
        User user = authService.findUserByEmail();
        userService.editUser(userForUpdateDTO, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
