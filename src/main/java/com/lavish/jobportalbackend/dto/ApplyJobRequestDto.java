package com.lavish.jobportalbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyJobRequestDto {
    private Long jobId;
    private Long candidateId;
}
