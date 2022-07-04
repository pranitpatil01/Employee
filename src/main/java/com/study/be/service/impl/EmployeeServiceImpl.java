package com.study.be.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.be.dto.EmployeeDao;
import com.study.be.exception.EmployeeServiceException;
import com.study.be.repository.EmployeeRepository;
import com.study.be.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	EmployeeRepository repository;

	@Override
	public EmployeeDao insertEmployee(EmployeeDao employee) throws EmployeeServiceException {
		log.debug("Entered into insertEmployee( )");
		try {
			return repository.save(employee);
		} catch (Exception e) {
			log.error("Exception occured while inserting employee ", e);
			throw new EmployeeServiceException("Failed to insert Employee", e);
		}
	}

	@Override
	public EmployeeDao getEmployee(Integer id) throws EmployeeServiceException {
		log.debug("Entered into getEmployee( )");
		EmployeeDao emp = null;
		try {
			emp = repository.findById(id).get();
		} catch (Exception e) {
			log.error("Exception occured while get employee ", e);
			throw new EmployeeServiceException("Failed to get Employee", e);
		}
		return emp;
	}

	@Override
	public List<EmployeeDao> getAllEmployee() throws EmployeeServiceException {
		log.debug("Entered into getAllEmployee( )");
		List<EmployeeDao> empList = null;
		try {
			empList = repository.findAll();
		} catch (Exception e) {
			log.error("Exception occured while get all employee ", e);
			throw new EmployeeServiceException("Failed to get all Employee", e);
		}
		return empList;
	}

	@Override
	public EmployeeDao modifyEmployee(EmployeeDao employee) throws EmployeeServiceException {
		log.debug("Entered into modifyEmployee( )");
		try {
			return repository.save(employee);
		} catch (Exception e) {
			log.error("Exception occured while update employee ", e);
			throw new EmployeeServiceException("Failed to update Employee", e);
		}
	}

	@Override
	public Integer removeEmployee(Integer id) throws EmployeeServiceException {
		log.debug("Entered into removeEmployee( )");
		try {
			repository.deleteById(id);;
			return id;
		} catch (Exception e) {
			log.error("Exception occured while remove employee ", e);
			throw new EmployeeServiceException("Failed to remove Employee", e);
		}
	}

}
