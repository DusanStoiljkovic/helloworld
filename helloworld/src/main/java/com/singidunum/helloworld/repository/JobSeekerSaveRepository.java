package com.singidunum.helloworld.repository;

import com.singidunum.helloworld.entity.JobPostActivity;
import com.singidunum.helloworld.entity.JobSeekerProfile;
import com.singidunum.helloworld.entity.JobSeekerSave;
import com.singidunum.helloworld.service.JobSeekerSaveService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

    void deleteByJob(JobPostActivity job);
}
