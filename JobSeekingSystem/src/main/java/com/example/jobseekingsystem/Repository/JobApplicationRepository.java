package com.example.jobseekingsystem.Repository;

import com.example.jobseekingsystem.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
}
