package com.singidunum.helloworld.repository;

import com.singidunum.helloworld.entity.IRecruiterJobs;
import com.singidunum.helloworld.entity.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
    @Query(value = "SELECT COUNT(s.user_id) as totalCandidates, " +
            "j.job_post_id, " +
            "j.job_title, " +
            "l.id as locationId, " +
            "l.city, " +
            "l.state, " +
            "l.country, " +
            "c.id as companyId, " +
            "c.name " +
            "FROM job_post_activity j " +
            "INNER JOIN job_location l on j.job_location_id = l.id " +
            "INNER JOIN job_company c on j.job_company_id = c.id " +
            "LEFT JOIN job_seeker_apply s on s.job = j.job_post_id " +
            "WHERE j.posted_by_id = :recruiter " +
            "GROUP BY j.job_post_id", nativeQuery = true)
    List<IRecruiterJobs> getRecruiterJobs(@Param("recruiter") int recruiter);
}
