package com.lavish.jobportalbackend.Repository;

import com.lavish.jobportalbackend.models.HiringRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiringRecordRepository extends JpaRepository<HiringRecord, Long> {
}
