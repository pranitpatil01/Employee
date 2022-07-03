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
import com.study.be.dto.Address;
import com.study.be.exception.AddressServiceException;
import com.study.be.service.AddressService;
import com.study.be.utils.JSONTags;
import com.study.be.utils.JsonResponse;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/address")
public class AddressController {

private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
	AddressService service;
	
	@ApiOperation(value = "To Add Address")
	@RequestMapping(value = {APINames.ADD_ADDRESS}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> addAddress(@RequestBody Address Address){
		log.debug("Entered into addAddress( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			service.insertAddress(Address);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (AddressServiceException ex) {
			log.error("Exception occured while adding Address",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to add");
			vo.setStatus(false);
		}
		return vo;
	}
	
	@ApiOperation(value = "To get Address by id")
	@RequestMapping(value = {APINames.GET_ADDRESS_BY_ID}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> getAddressById(@RequestParam Integer id){
		log.debug("Entered into addAddress( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			Address Address=service.getAddress(id);
			vo.setResponseBody(Address);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (AddressServiceException ex) {
			log.error("Exception occured while get Address by id ::"+id +" ",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to add");
			vo.setStatus(false);
		}
		return vo;
	}
	
	@ApiOperation(value = "To get all Address")
	@RequestMapping(value = {APINames.ADDRESSES}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> Addresss(){
		log.debug("Entered into Addresss( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			List<Address> Addresss=service.getAllAddress();
			vo.setResponseBody(Addresss);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (AddressServiceException ex) {
			log.error("Exception occured while get all Addresss",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to get Address list");
			vo.setStatus(false);
		}
		return vo;
	}

	
	@ApiOperation(value = "To delete Address")
	@RequestMapping(value = {APINames.DELETE_ADDRESS}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> depleteAddress(@RequestParam Integer id){
		log.debug("Entered into depleteAddress( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			Integer addId=service.removeAddress(id);
			vo.setResponseBody(addId);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (AddressServiceException ex) {
			log.error("Exception occured while delete Address of id "+id +" ",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to delete Address");
			vo.setStatus(false);
		}
		return vo;
	}
	
	@ApiOperation(value = "To update Address")
	@RequestMapping(value = {APINames.UPDATE_ADDRESS}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse<Object> updateAddress(@RequestBody Address Address){
		log.debug("Entered into updateAddress( )");
		JsonResponse<Object> vo= new JsonResponse<Object>();
		try {
			Address address=service.modifyAddress(Address);
			vo.setResponseBody(address);
			vo.setResponseDetail(JSONTags.TAG_STATUS_SUCCESS);
			vo.setStatus(true);
		}catch (AddressServiceException ex) {
			log.error("Exception occured while update Address ",ex);
			vo.setResponseDetail(JSONTags.TAG_STATUS_FAILED);
			vo.setResponseDetail("Failed to update Address");
			vo.setStatus(false);
		}
		return vo;
	}
	
}
