package miu.ea.group3g.lab4.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.aop.ExecutionTime;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/add")
    public String handlePost(@RequestBody User user) {
        try {
            return userService.getUser(1L).toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
