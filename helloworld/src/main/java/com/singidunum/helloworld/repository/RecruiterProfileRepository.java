package com.singidunum.helloworld.repository;

import com.singidunum.helloworld.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Integer> {

}
