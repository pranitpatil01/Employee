package com.study.be.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.be.APINames;
import com.study.be.dto.EmployeeDao;
import com.study.be.exception.EmployeeServiceException;
import com.study.be.service.EmployeeService;
import com.study.be.utils.JSONTags;
import com.study.be.utils.JsonResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
	EmployeeService service;
	
	@ApiOperation(value = "To Add Employee")
	@RequestMapping(value = {APINames.ADD_EMPLOYEE}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> addEmployee(@RequestBody EmployeeDao employee){
		log.debug("Entered into addEmployee( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			EmployeeDao emp = service.insertEmployee(employee);
			vo.setResponseBody(emp);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (EmployeeServiceException ex) {
			log.error("Exception occured while adding Employee",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to add");
			vo.setStatus(false);
		}
		return vo;
	}
	
	@ApiOperation(value = "To get Employee by id")
	@RequestMapping(value = {APINames.GET_ADDRESS_BY_ID}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> getEmployeeById(@RequestParam Integer id){
		log.debug("Entered into addEmployee( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			EmployeeDao employee=service.getEmployee(id);
			vo.setResponseBody(employee);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (EmployeeServiceException ex) {
			log.error("Exception occured while get Employee by id ::"+id +" ",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to add");
			vo.setStatus(false);
		}
		return vo;
	}
	
	@ApiOperation(value = "To get all Employee")
	@RequestMapping(value = {APINames.EMPLOYEES}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> employees(){
		log.debug("Entered into employees( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			List<EmployeeDao> employees=service.getAllEmployee();
			vo.setResponseBody(employees);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (EmployeeServiceException ex) {
			log.error("Exception occured while get all Employees",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to get employee list");
			vo.setStatus(false);
		}
		return vo;
	}

	
	@ApiOperation(value = "To delete employee")
	@RequestMapping(value = {APINames.DELETE_EMPLOYEE}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> depleteEmployee(@RequestParam Integer id){
		log.debug("Entered into depleteEmployee( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			Integer empId=service.removeEmployee(id);
			vo.setResponseBody(empId);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (EmployeeServiceException ex) {
			log.error("Exception occured while delete Employee of id "+id +" ",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to delete employee");
			vo.setStatus(false);
		}
		return vo;
	}
	
	@ApiOperation(value = "To update employee")
	@RequestMapping(value = {APINames.UPDATE_EMPLOYEE}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> updateEmployee(@RequestBody EmployeeDao employee){
		log.debug("Entered into updateEmployee( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			EmployeeDao emp=service.modifyEmployee(employee);
			vo.setResponseBody(emp);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (EmployeeServiceException ex) {
			log.error("Exception occured while update Employee ",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to update employee");
			vo.setStatus(false);
		}
		return vo;
	}
}
