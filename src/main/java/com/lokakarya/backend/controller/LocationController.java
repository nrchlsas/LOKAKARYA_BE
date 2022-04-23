package com.lokakarya.backend.controller;


import com.lokakarya.backend.entity.Location;
import com.lokakarya.backend.service.LocationService;
import com.lokakarya.backend.util.DataResponse;
import com.lokakarya.backend.util.DataResponseList;
import com.lokakarya.backend.util.DataResponsePagination;
import com.lokakarya.backend.wrapper.LocationWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/locations")
public class LocationController {
    
    @Autowired
    LocationService locationService;

	// GET BY ID
    @RequestMapping(path = "/getById", method = RequestMethod.GET)
	public DataResponse<LocationWrapper> getByLocationId(@RequestParam("id") Long locationId) {
		return new DataResponse<LocationWrapper>(locationService.getByLocationId(locationId));
	}
	
	// FIND ALL
	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public DataResponseList<LocationWrapper> findAll() {
		return new DataResponseList<LocationWrapper>(locationService.findAll());
	}
	
	// FIND ALL WITH PAGINATION
	@GetMapping(path = "/findAllWithPagination")
	public DataResponsePagination<LocationWrapper, Location> findAllWithPagination(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		return new DataResponsePagination<LocationWrapper, Location>(locationService.findaAllWithPagination(page, size));
	}
	
	// FIND BY STREET ADDRESS WITH PAGINATION
	@GetMapping(path = "/findByStreetAddressWithPagination")
	public DataResponsePagination<LocationWrapper, Location> findByStreetAddressWithPagination(
			@RequestParam("streetAddresss") String streetAddress, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		return new DataResponsePagination<LocationWrapper, Location>(locationService.findByStreetAddressContaining(streetAddress, page, size));
	}

	// FIND BY STREET ADDRESS
	@GetMapping(path = "/getByStreetAddress")
	DataResponseList<LocationWrapper> getByStreetAddress(@RequestParam("streetAddress") String streetAddress){
		return new DataResponseList<LocationWrapper>(locationService.getByStreetAddress(streetAddress));
	}
	
	// FIND BY CITY
	@GetMapping(path = "/getByCity")
	DataResponseList<LocationWrapper> getByCity(@RequestParam("city") String city){
		return new DataResponseList<LocationWrapper>(locationService.getByCity(city));
	}

	// FIND BY PROVINCE STATE
	@GetMapping(path = "/getByStateProvince")
	DataResponseList<LocationWrapper> getByStateProvince(@RequestParam("stateProvince") String stateProvince){
		return new DataResponseList<LocationWrapper>(locationService.getByStateProvince(stateProvince));
	}

	// FIND BY COUNTRY NAME
	@GetMapping(path = "/getByCountryName")
	DataResponseList<LocationWrapper> getByCountryName(@RequestParam("countryName") String countryName){
		return new DataResponseList<LocationWrapper>(locationService.getByCountryName(countryName));
	}

	// FIND STATE PROVINCE BY COUNTRY ID
	@GetMapping(path = "/getStateProvinceByCountryId")
	DataResponseList<String> getStateProvByCountry(@RequestParam("countryId") String countryId){
		return new DataResponseList<String>(locationService.getStateProvinceByCountryId(countryId));
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long locationId) {
		locationService.delete(locationId);
	}
	
	// POST / ADD
	@PostMapping(path="/post")
	public DataResponse<LocationWrapper> save(@RequestBody LocationWrapper wrapper) {
		return new DataResponse<LocationWrapper>(locationService.save(wrapper));
	}
	
	// PUT / EDIT
	@PutMapping(path="/put")
	public DataResponse<LocationWrapper> update(@RequestBody LocationWrapper wrapper) {
		return new DataResponse<LocationWrapper>(locationService.save(wrapper));
	}	
}


