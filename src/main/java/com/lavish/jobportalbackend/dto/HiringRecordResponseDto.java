package com.lavish.jobportalbackend.dto;

import com.lavish.jobportalbackend.models.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HiringRecordResponseDto {
    private Long id;
    private Long jobId;
    private Long candidateId;
    private ApplicationStatus status;
}
