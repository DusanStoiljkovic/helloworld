package com.singidunum.helloworld.repository;

import com.singidunum.helloworld.entity.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {

}
