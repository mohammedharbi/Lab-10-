package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.ApiResponse.ApiResponse;
import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Service.JobApplicationService;
import com.example.jobseekingsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body(new ApiResponse("User added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdated = userService.updateUser(id, user);

        if(isUpdated){
            return ResponseEntity.status(201).body(new ApiResponse("User updated"));
        } else return ResponseEntity.status(400).body(new ApiResponse("User not updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(201).body(new ApiResponse("User deleted"));
        }else return ResponseEntity.status(400).body(new ApiResponse("User not deleted"));
    }

    @GetMapping("/getAllJobApplications")
    public ResponseEntity getJobApplication() {
        return ResponseEntity.status(200).body(userService.getAllJobApplications());
    }
    @PostMapping("/applyJobApplication")
    public ResponseEntity applyForJobApplication(@RequestBody @Valid JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.applyJobApplication(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("jobApplication sent successfully"));
    }
    @DeleteMapping("/withdrawJobApplication/{id}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer id) {
        Boolean isDeleted = userService.withdrawJobApplication(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("jobApplication withdraw successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("jobApplication withdraw failed"));
    }

}
