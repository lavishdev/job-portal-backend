package com.lavish.jobportalbackend.dto;

import com.lavish.jobportalbackend.models.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobRequestDto {
    private String title;
    private String description;
    private JobType jobType;
    private Double minSalary;
    private Double maxSalary;
}
