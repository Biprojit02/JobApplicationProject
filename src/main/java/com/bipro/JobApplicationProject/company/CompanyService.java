package com.bipro.JobApplicationProject.company;

import java.util.List;

public interface CompanyService {
    List<Company> getALlCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
//    String getCompanyById(Long id);
}
