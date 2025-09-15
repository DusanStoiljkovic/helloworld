package com.singidunum.helloworld.service;

import com.singidunum.helloworld.entity.RecruiterProfile;
import com.singidunum.helloworld.entity.Users;
import com.singidunum.helloworld.repository.RecruiterProfileRepository;
import com.singidunum.helloworld.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterProfileService {
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @Autowired
    public RecruiterProfileService(RecruiterProfileRepository recruiterProfileRepository, UsersService usersService, UsersRepository usersRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    public Optional<RecruiterProfile> getOne(Integer id) {
        return recruiterProfileRepository.findById(id);
    }

    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepository.save(recruiterProfile);
    }

    public RecruiterProfile getCurrentRecruiterProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            Users user = usersRepository.findByEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("Could not find User"));
            Optional<RecruiterProfile> recruiterProfile = getOne(user.getUserId());
            return recruiterProfile.orElse(null);
        } else {
            return null;
        }
    }
}
