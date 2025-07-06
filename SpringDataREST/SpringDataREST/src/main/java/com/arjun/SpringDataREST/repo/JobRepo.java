package com.arjun.SpringDataREST.repo;

import com.arjun.SpringDataREST.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<JobPost,Integer> {
}

// Here by creating just a REPO and MODEL we are able to send requests.
// Spring Data REST automatically creates the controllers and service for us.
// This works when we perform basic functions inside the controller and service layers.
// The dependency responsible for this is Spring Data REST.