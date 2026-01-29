package com.lavish.jobportalbackend.services;

import com.lavish.jobportalbackend.Repository.HiringRecordRepository;
import com.lavish.jobportalbackend.Repository.JobRepository;
import com.lavish.jobportalbackend.Repository.UserRepository;
import com.lavish.jobportalbackend.models.ApplicationStatus;
import com.lavish.jobportalbackend.models.HiringRecord;
import com.lavish.jobportalbackend.models.Job;
import com.lavish.jobportalbackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringRecordService {
    @Autowired
    private HiringRecordRepository hiringRecordRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;


    public HiringRecord applyForJob(Long jobId, Long candidateId) {

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));


        User candidate = userRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        if (hiringRecordRepository
                .findByCandidateIdAndJobId(candidateId, jobId)
                .isPresent()) {
            throw new RuntimeException("You have already applied for this job");
        }

        HiringRecord record = new HiringRecord();
        record.setJob(job);
        record.setCandidate(candidate);
        record.setStatus(ApplicationStatus.PENDING);

        return hiringRecordRepository.save(record);

    }

    public List<HiringRecord> getApplicationsByCandidate(Long candidateId) {
        return hiringRecordRepository.findByCandidateId(candidateId);
    }

    public List<HiringRecord> getApplicationsForJob(Long jobId) {
        return hiringRecordRepository.findByJobId(jobId);
    }

    public HiringRecord updateApplicationStatus(Long hiringRecordId, ApplicationStatus status) {
        HiringRecord record = hiringRecordRepository.findById(hiringRecordId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        record.setStatus(status);

        return hiringRecordRepository.save(record);
    }


}
