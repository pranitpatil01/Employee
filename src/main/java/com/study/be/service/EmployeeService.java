package com.study.be.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.be.dto.EmployeeDao;
import com.study.be.exception.EmployeeServiceException;

@Service
public interface EmployeeService {
	
	public EmployeeDao insertEmployee(EmployeeDao employee) throws EmployeeServiceException;
	public EmployeeDao getEmployee(Integer id) throws EmployeeServiceException;
	public List<EmployeeDao> getAllEmployee() throws EmployeeServiceException;
	public EmployeeDao modifyEmployee(EmployeeDao employee) throws EmployeeServiceException;
	public Integer removeEmployee(Integer id) throws EmployeeServiceException;

}
