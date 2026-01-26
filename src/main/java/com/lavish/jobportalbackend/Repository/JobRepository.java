package com.lavish.jobportalbackend.Repository;

import com.lavish.jobportalbackend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
