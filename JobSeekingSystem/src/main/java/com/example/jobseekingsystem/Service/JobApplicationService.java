package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;

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
