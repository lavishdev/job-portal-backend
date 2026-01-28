package com.lavish.jobportalbackend.Repository;

import com.lavish.jobportalbackend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);

}
