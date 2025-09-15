package com.singidunum.helloworld.service;

import com.singidunum.helloworld.entity.JobSeekerProfile;
import com.singidunum.helloworld.entity.Users;
import com.singidunum.helloworld.repository.JobSeekerProfileRepository;
import com.singidunum.helloworld.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JobSeekerProfileService {
    private final UsersRepository usersRepository;
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    public Optional<JobSeekerProfile> getOne(int id) {
        return jobSeekerProfileRepository.findById(id);
    }

    public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
        return jobSeekerProfileRepository.save(jobSeekerProfile);
    }


    public JobSeekerProfile getCurrentSeekerProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            Users user = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could not find user " + username));
            Optional<JobSeekerProfile> jobSeekerProfile = getOne(user.getUserId());
            return jobSeekerProfile.orElse(null);
        } else return null;
    }
}
