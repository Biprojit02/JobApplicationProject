package com.bipro.JobApplicationProject.company.impl;

import com.bipro.JobApplicationProject.company.Company;
import com.bipro.JobApplicationProject.company.CompanyRepository;
import com.bipro.JobApplicationProject.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public String getCompanyById(Long id) {
        return "";
    }

    @Override
    public String createCompany(Company company) {
        return "";
    }
}
