package com.lavish.jobportalbackend.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "hiring_records",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"candidate_id", "job_id"})
        }
)
public class HiringRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User candidate;

    @ManyToOne
    private Job job;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.APPLIED;

    private String resumeUrl;

}
