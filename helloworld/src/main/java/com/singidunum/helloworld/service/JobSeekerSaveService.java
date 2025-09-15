package com.singidunum.helloworld.service;

import com.singidunum.helloworld.entity.JobPostActivity;
import com.singidunum.helloworld.entity.JobSeekerProfile;
import com.singidunum.helloworld.entity.JobSeekerSave;
import com.singidunum.helloworld.repository.JobSeekerSaveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobSeekerSaveService {
    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId) {
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job) {
        return jobSeekerSaveRepository.findByJob(job);
    }
}
