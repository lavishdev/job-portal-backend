package com.lavish.jobportalbackend.Repository;

import com.lavish.jobportalbackend.models.HiringRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HiringRecordRepository extends JpaRepository<HiringRecord, Long> {
    Optional<HiringRecord> findByCandidateIdAndJobId(Long candidateId, Long jobId);
    List<HiringRecord> findByCandidateId(Long candidateId);
    List<HiringRecord> findByJobId(Long jobId);



}
