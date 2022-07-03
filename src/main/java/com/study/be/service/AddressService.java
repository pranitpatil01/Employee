package com.study.be.service;

import java.util.List;

import com.study.be.dto.Address;
import com.study.be.exception.AddressServiceException;

public interface AddressService {
	public void insertAddress(Address employee) throws AddressServiceException;
	public Address getAddress(Integer id) throws AddressServiceException;
	public List<Address> getAllAddress() throws AddressServiceException;
	public Address modifyAddress(Address employee) throws AddressServiceException;
	public Integer removeAddress(Integer id) throws AddressServiceException;

}
