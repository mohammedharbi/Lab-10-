package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.JobApplicationRepository;
import com.example.jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JobApplicationRepository jobApplicationRepository;

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
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }
    public void applyJobApplication(JobApplication jobApplication) {
        jobApplicationRepository.save(jobApplication);
    }
    public Boolean withdrawJobApplication(Integer id) {
        JobApplication oldJobApplication = jobApplicationRepository.findById(id).get();
        if (oldJobApplication != null) {
            jobApplicationRepository.delete(oldJobApplication);
            return true;
        }
        return false;
    }

}
