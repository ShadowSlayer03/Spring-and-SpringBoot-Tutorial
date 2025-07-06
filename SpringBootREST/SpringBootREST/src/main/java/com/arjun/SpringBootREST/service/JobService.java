package com.arjun.SpringBootREST.service;

import com.arjun.SpringBootREST.model.JobPost;
import com.arjun.SpringBootREST.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }

    public JobPost getJobById(int id){
        return jobRepo.getJobById(id);
    }

    public void deleteJob(int id) {
        jobRepo.deleteJob(id);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.updateJob(jobPost);
    }
}
