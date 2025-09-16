package com.singidunum.helloworld.repository;

import com.singidunum.helloworld.entity.JobPostActivity;
import com.singidunum.helloworld.entity.JobSeekerApply;
import com.singidunum.helloworld.entity.JobSeekerProfile;
import com.singidunum.helloworld.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);
    List<JobSeekerApply> findByJob(JobPostActivity job);

    void deleteByJob(JobPostActivity job);
}
