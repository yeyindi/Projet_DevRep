package devrep.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.interfaces.UserRepository;
import devrep.project.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
    
    public UserController(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }
 
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/api/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}