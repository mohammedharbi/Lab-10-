package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.ApiResponse.ApiResponse;
import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job_application")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getJobApplication() {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplications());
    }
    @PostMapping("/add")
    public ResponseEntity applyForJobApplication(@RequestBody @Valid JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobApplicationService.applyJobApplication(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("jobApplication sent successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id) {
        Boolean isDeleted = jobApplicationService.withdrawJobApplication(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("jobApplication withdraw successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("jobApplication withdraw failed"));
    }
}
