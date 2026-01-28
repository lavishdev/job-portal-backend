package com.lavish.jobportalbackend.services;

import com.lavish.jobportalbackend.Repository.CompanyRepository;
import com.lavish.jobportalbackend.Repository.JobRepository;
import com.lavish.jobportalbackend.dto.CreateJobRequestDto;
import com.lavish.jobportalbackend.models.Company;
import com.lavish.jobportalbackend.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Job createJob(CreateJobRequestDto dto, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setJobType(dto.getJobType());
        job.setMinSalary(dto.getMinSalary());
        job.setMaxSalary(dto.getMaxSalary());
        job.setCompany(company);

        return jobRepository.save(job);

    }

    public Job updateJob(Long jobId, CreateJobRequestDto dto) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setJobType(dto.getJobType());
        job.setMinSalary(dto.getMinSalary());
        job.setMaxSalary(dto.getMaxSalary());

        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(()->new RuntimeException("Job not found"));
    }

    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}
