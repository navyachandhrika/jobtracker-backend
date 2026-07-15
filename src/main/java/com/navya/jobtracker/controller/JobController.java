package com.navya.jobtracker.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.navya.jobtracker.entity.Job;
import com.navya.jobtracker.service.JobService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    // Create Job
    @PostMapping
    public Job createJob(@Valid @RequestBody Job job) {
        return service.saveJob(job);
    }

    // Get All Jobs
    @GetMapping
    public List<Job> getJobs() {
        return service.getAllJobs();
    }

    // Get Job by ID
    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id) {
        return service.getJob(id);
    }

    // Get Jobs by Company
    @GetMapping("/company/{companyName}")
    public List<Job> getJobsByCompany(@PathVariable String companyName) {
        return service.getJobsByCompany(companyName);
    }

    // Get Jobs by Status
    @GetMapping("/status/{status}")
    public List<Job> getJobsByStatus(@PathVariable String status) {
        return service.getJobsByStatus(status);
    }

    // Update Job
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id,
                         @Valid @RequestBody Job job) {

        return service.updateJob(id, job);
    }

    // Delete Job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return "Job Deleted Successfully";
    }
    @GetMapping("/count")
    public long getTotalJobs() {
        return service.getTotalJobs();
    }

    @GetMapping("/stats")
    public Map<String, Long> getStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("Applied", service.getAppliedCount());
        stats.put("Interview", service.getInterviewCount());
        stats.put("Rejected", service.getRejectedCount());
        stats.put("Offer", service.getOfferCount());

        return stats;
    }

}