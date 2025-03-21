package com.bipro.JobApplicationProject.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobs;
    }

    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job job){
        jobs.add(job);
        return "Job added successfully";
    }

    /*@DeleteMapping("/jobs/id")
    public void deleteJobs(@RequestBody long id){
        jobs.remove(id);
    }*/
}
