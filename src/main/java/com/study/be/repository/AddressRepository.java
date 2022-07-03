package com.study.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.be.dto.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
