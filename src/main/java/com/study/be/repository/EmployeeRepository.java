package com.study.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.be.dto.EmployeeDao;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDao, Integer>{

}
