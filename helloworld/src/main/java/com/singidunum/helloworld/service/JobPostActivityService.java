package com.singidunum.helloworld.service;

import com.singidunum.helloworld.entity.*;
import com.singidunum.helloworld.repository.JobPostActivityRepository;
import com.singidunum.helloworld.repository.JobSeekerApplyRepository;
import com.singidunum.helloworld.repository.JobSeekerSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobPostActivityService {

    private final JobPostActivityRepository jobPostActivityRepository;
    private final JobSeekerApplyService jobSeekerApplyService;
    private final JobSeekerApplyRepository jobSeekerApplyRepository;
    private final JobSeekerSaveService jobSeekerSaveService;
    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    @Autowired
    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository, JobSeekerApplyService jobSeekerApplyService, JobSeekerApplyRepository jobSeekerApplyRepository, JobSeekerSaveService jobSeekerSaveService, JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
        this.jobSeekerApplyService = jobSeekerApplyService;
        this.jobSeekerApplyRepository = jobSeekerApplyRepository;
        this.jobSeekerSaveService = jobSeekerSaveService;
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public JobPostActivity getOne(int id) {
        return jobPostActivityRepository.findById(id).orElseThrow(()-> new RuntimeException("Job not found"));
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }

    public List<RecruiterJobsDto> getRecruiterJobs(int recruiter) {
       List<IRecruiterJobs> recruiterJobs = jobPostActivityRepository.getRecruiterJobs(recruiter);
       List<RecruiterJobsDto> recruiterJobsDtoList = new ArrayList<>();
       for(IRecruiterJobs recruiterJob : recruiterJobs) {
           JobLocation loc = new JobLocation(recruiterJob.getLocationId(), recruiterJob.getCity(),
                   recruiterJob.getState(), recruiterJob.getCountry());
           JobCompany comp = new JobCompany(recruiterJob.getCompanyId(), recruiterJob.getName(), "");
           recruiterJobsDtoList.add(new RecruiterJobsDto(recruiterJob.getTotalCandidates(), recruiterJob.getJob_post_id(),
                   recruiterJob.getJob_title(), loc, comp));
       }
       return recruiterJobsDtoList;
    }

    public List<JobPostActivity> getAll() {
        return jobPostActivityRepository.findAll();
    }

    public List<JobPostActivity> search(String job, String location, List<String> type, List<String> remote, LocalDate searchDate) {
        return Objects.isNull(searchDate)?jobPostActivityRepository.searchWithoutDate(job, location, remote, type):
                jobPostActivityRepository.search(job, location, remote, type, searchDate);
    }

    @Transactional
    public void delete(JobPostActivity job) {
        List<JobSeekerApply> applies = jobSeekerApplyService.getJobCandidates(job);
        List<JobSeekerSave> saveList = jobSeekerSaveService.getJobCandidates(job);
        if(!applies.isEmpty()) {
            for(JobSeekerApply applie : applies) {
                jobSeekerApplyRepository.deleteByJob(job);
            }
        }
        if (!saveList.isEmpty()) {
            for(JobSeekerSave save: saveList) {
                jobSeekerSaveRepository.deleteByJob(job);
            }
        }
        jobPostActivityRepository.delete(job);
    }
}
