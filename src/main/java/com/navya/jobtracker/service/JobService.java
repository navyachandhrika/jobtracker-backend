package com.navya.jobtracker.service;

import com.navya.jobtracker.entity.Job;
import com.navya.jobtracker.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public Job saveJob(Job job) {
        return repository.save(job);
    }

    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    public Job getJob(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteJob(Long id) {
        repository.deleteById(id);
    }

    public Job updateJob(Long id, Job updatedJob) {

        Job existingJob = repository.findById(id).orElse(null);

        if (existingJob != null) {
            existingJob.setCompanyName(updatedJob.getCompanyName());
            existingJob.setJobTitle(updatedJob.getJobTitle());
            existingJob.setLocation(updatedJob.getLocation());
            existingJob.setStatus(updatedJob.getStatus());
            existingJob.setAppliedDate(updatedJob.getAppliedDate());

            return repository.save(existingJob);
        }

        return null;
    }
    public List<Job> getJobsByCompany(String companyName) {
        return repository.findByCompanyName(companyName);
    }
    public List<Job> getJobsByStatus(String status) {
        return repository.findByStatus(status);
    }
    public long getTotalJobs() {
        return repository.count();
    }

    public long getAppliedCount() {
        return repository.countByStatus("Applied");
    }

    public long getInterviewCount() {
        return repository.countByStatus("Interview");
    }

    public long getRejectedCount() {
        return repository.countByStatus("Rejected");
    }

    public long getOfferCount() {
        return repository.countByStatus("Offer");
    }
}