package com.arjun.SpringbootJobPortal.SpringbootJobPortal.controller;

import com.arjun.SpringbootJobPortal.SpringbootJobPortal.model.JobPost;
import com.arjun.SpringbootJobPortal.SpringbootJobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/","home"})
    public String goHome(){
        return "home";
    }

    @GetMapping({"/addjob"})
    public String addJob(){
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model model){
        List<JobPost> jobs = service.getAllJobs();
        model.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }
}
