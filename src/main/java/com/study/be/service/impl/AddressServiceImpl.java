package com.study.be.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.be.dto.Address;
import com.study.be.exception.AddressServiceException;
import com.study.be.repository.AddressRepository;
import com.study.be.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	AddressRepository repository;

	@Override
	public Address insertAddress(Address address) throws AddressServiceException {
		log.debug("Entered into insertAddress( )");
		try {
			return repository.save(address);
		} catch (Exception e) {
			log.error("Exception occured while inserting address ", e);
			throw new AddressServiceException("Failed to insert Address", e);
		}
	}

	@Override
	public Address getAddress(Integer id) throws AddressServiceException {
		log.debug("Entered into getAddress( )");
		Address address = null;
		try {
			address = repository.findById(id).get();
		} catch (Exception e) {
			log.error("Exception occured while get address ", e);
			throw new AddressServiceException("Failed to get Address", e);
		}
		return address;
	}

	@Override
	public List<Address> getAllAddress() throws AddressServiceException {
		log.debug("Entered into getAllAddress( )");
		List<Address> addressList = null;
		try {
			addressList = repository.findAll();
		} catch (Exception e) {
			log.error("Exception occured while get all address ", e);
			throw new AddressServiceException("Failed to get all Address", e);
		}
		return addressList;
	}

	@Override
	public Address modifyAddress(Address address) throws AddressServiceException {
		log.debug("Entered into modifyAddress( )");
		try {
			return repository.save(address);
		} catch (Exception e) {
			log.error("Exception occured while update address ", e);
			throw new AddressServiceException("Failed to update Address", e);
		}
	}

	@Override
	public Integer removeAddress(Integer id) throws AddressServiceException {
		log.debug("Entered into removeAddress( )");
		try {
			repository.deleteById(id);;
			return id;
		} catch (Exception e) {
			log.error("Exception occured while remove address ", e);
			throw new AddressServiceException("Failed to remove Address", e);
		}
	}

}
