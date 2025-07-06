package com.arjun.SpringBootREST.controller;

import com.arjun.SpringBootREST.model.JobPost;
import com.arjun.SpringBootREST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller is a bean used to specify that this particular class acts as a controller.
// But the default return in @Controller is a view - html or jsp so we need to use @ResponseBody on the methods.
// Otherwise to specify that only data is being returned from the controller methods we can use @RestController.
@RestController
// We need to specify the frontend url to get rid of CORS issues.
@CrossOrigin(origins = "http://localhost:3000")
public class JobRESTController {
    @Autowired
    private JobService service;

    // Can only return JSON content
    @GetMapping(path="/jobPosts", produces={"application/json"})
    //@ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{id}")
    public JobPost getJobById(@PathVariable int id){
        return service.getJobById(id);
    }

    // Can only accept XML data
    @PostMapping(path="/jobPost", consumes={"application/xml"})
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("/deleteJob/{id}")
    public List<JobPost> deleteJob(@PathVariable int id){
        service.deleteJob(id);
        return service.getAllJobs();
    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJobById(jobPost.getPostId());
    }
}


