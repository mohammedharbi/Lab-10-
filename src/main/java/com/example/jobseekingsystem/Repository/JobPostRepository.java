package com.example.jobseekingsystem.Repository;

import com.example.jobseekingsystem.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
}
