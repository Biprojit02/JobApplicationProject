package com.bipro.JobApplicationProject.company.impl;

import com.bipro.JobApplicationProject.company.Company;
import com.bipro.JobApplicationProject.company.CompanyRepository;
import com.bipro.JobApplicationProject.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getALlCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
            company.getJobs().clear(); // Remove jobs first
            companyRepository.delete(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> compannyOptional = companyRepository.findById(id);
        if(compannyOptional.isPresent()){
            Company companyToUpdate = compannyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }
}
