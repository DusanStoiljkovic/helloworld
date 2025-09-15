package com.singidunum.helloworld.service;

import com.singidunum.helloworld.entity.JobPostActivity;
import com.singidunum.helloworld.entity.JobSeekerApply;
import com.singidunum.helloworld.entity.JobSeekerProfile;
import com.singidunum.helloworld.repository.JobSeekerApplyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobSeekerApplyService {
    private final JobSeekerApplyRepository jobSeekerApplyRepository;

    public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId) {
        return jobSeekerApplyRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerApply> getJobCandidates(JobPostActivity job) {
        return jobSeekerApplyRepository.findByJob(job);
    }

    public void addNew(JobSeekerApply jobSeekerApply) {
        jobSeekerApplyRepository.save(jobSeekerApply);
    }
}
