package com.bipro.JobApplicationProject.company;

import java.util.List;

public interface CompanyService {
    List<Company> getALlCompanies();
    String getCompanyById(Long id);
    String createCompany(Company company);
}
