package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
    public boolean updateUser(Integer id,User user) {
        User oldUser = userRepository.findById(id).get();

        if (oldUser != null) {
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(user.getRole());
            oldUser.setAge(user.getAge());
            userRepository.save(oldUser);
            return true;
        }
        return false;
    }
    public boolean deleteUser(Integer id) {
        User oldUser = userRepository.findById(id).get();
        if (oldUser != null) {
            userRepository.delete(oldUser);
        }
        return false;
    }

}
