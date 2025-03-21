package com.bipro.JobApplicationProject.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob();
}
