package com.lavish.jobportalbackend.services;

import com.lavish.jobportalbackend.Repository.CompanyRepository;
import com.lavish.jobportalbackend.Repository.UserRepository;
import com.lavish.jobportalbackend.dto.CreateCompanyRequestDto;
import com.lavish.jobportalbackend.models.Company;
import com.lavish.jobportalbackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    public Company createCompany(CreateCompanyRequestDto createCompanyRequestDto, Long ownerId) {
        if (companyRepository.findByName(createCompanyRequestDto.getName()).isPresent()) {
            throw new RuntimeException("company  already exists with this name");
        }

        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        Company company = new Company();
        company.setName(createCompanyRequestDto.getName());
        company.setDescription(createCompanyRequestDto.getDescription());
        company.setLocation( createCompanyRequestDto.getLocation());
        company.setOwner(owner);


        return  companyRepository.save(company);
    }

    public Company updateCompany(Long companyId, CreateCompanyRequestDto createCompanyRequestDto) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        company.setName(createCompanyRequestDto.getName());
        company.setDescription(createCompanyRequestDto.getDescription());
        company.setLocation(createCompanyRequestDto.getLocation());
        return   companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return  companyRepository.findAll();
    }

    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(()->new RuntimeException("company not found"));
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
