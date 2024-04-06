package miu.ea.group3g.lab4.service;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.aop.ExecutionTime;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @ExecutionTime
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @ExecutionTime
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
