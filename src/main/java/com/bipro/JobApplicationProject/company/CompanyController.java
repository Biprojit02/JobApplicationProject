package com.bipro.JobApplicationProject.company;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getALlCompanies(){
        return ResponseEntity.ok(companyService.getALlCompanies());
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(company, id);
//        return new ResponseEntity<>("Company update successfully", HttpStatus.OK);
        return ResponseEntity.ok("Company update successfully");
    }
}
