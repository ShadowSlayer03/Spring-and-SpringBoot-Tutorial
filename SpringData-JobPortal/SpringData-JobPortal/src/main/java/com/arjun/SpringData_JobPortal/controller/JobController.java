package com.arjun.SpringData_JobPortal.controller;

import com.arjun.SpringData_JobPortal.model.JobPost;
import com.arjun.SpringData_JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(path="/jobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping(path="/jobPost/{id}")
    public Optional<JobPost> getJobById(@PathVariable int id){
        return jobService.getJobById(id);
    }

    @PostMapping(path="/jobPost")
    public JobPost addJob(@RequestBody JobPost jp) {
        return jobService.addJob(jp);
    }

    @PutMapping(path="/jobPost")
    public void updateJob(@RequestBody JobPost jp){
        jobService.updateJob(jp);
    }

    @DeleteMapping(path="/jobPost")
    public void deleteJob(@RequestBody JobPost jp){
        jobService.deleteJob(jp);
    }

    @GetMapping(path="/load")
    public String load(){
        jobService.load();
        return "Success";
    }

    @GetMapping("/jobPost/search/{keyword}")
    public List<JobPost> searchJobs(@PathVariable String keyword){
        return jobService.search(keyword);
    }

}
