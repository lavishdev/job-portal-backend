package com.lavish.jobportalbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private Double minSalary;
    private Double maxSalary;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "job")
    private List<HiringRecord> applications;


}
