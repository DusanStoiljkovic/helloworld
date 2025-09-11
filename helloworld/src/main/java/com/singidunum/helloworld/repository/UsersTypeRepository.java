package com.singidunum.helloworld.repository;

import com.singidunum.helloworld.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {
}
