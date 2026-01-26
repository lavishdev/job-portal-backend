package com.lavish.jobportalbackend.Repository;

import com.lavish.jobportalbackend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
