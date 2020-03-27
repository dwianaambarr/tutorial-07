package com.apap.tu07.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.apap.tu07.model.FlightModel;
import com.apap.tu07.service.FlightService;

/**
 * FlightController
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping(value = "/add")
    public FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
    	return flightService.addFlight(flight);
    }

    @GetMapping(value = "/view/{flightNumber}")
	public Optional<FlightModel> viewFlight(@PathVariable("flightNumber") String flightNumber) {
		return flightService.getFlightDetailByFlightNumber(flightNumber);
	}

    @DeleteMapping(value= "/delete/{flightId}") 
	public String deleteFlight(@PathVariable(value="flightId") long flightId) { 
		FlightModel  flight = flightService.getFlightDetailById(flightId);
		flightService.deleteFlight(flight);
		return "flight has been deleted"; 
	} 

    @GetMapping(value="/all")
	public List<FlightModel> flightViewAll() {
		List<FlightModel> listFlight = flightService.getListFlight();
		return listFlight;
	}

    @PutMapping(value = "/update/{flightId}")
    public String updateFlightSubmit(@PathVariable("flightId") long flightId, @RequestParam(value = "destination", required = false) String destination, @RequestParam(value = "origin", required = false) String origin, @RequestParam(value = "time", required = false) Date time ) {
    	FlightModel flight = flightService.getFlightById(flightId);
    	if(flight.equals(null)) {
    		return "Couldn't find your flight";
    	}
    	if(destination != null) {
    		flight.setDestination(destination);
    	}
    	if(origin != null) {
    		flight.setOrigin(origin);
    	}
    	if(time != null) {
    		flight.setTime(time);
    	}

    	flightService.updateFlight(flightId, flight);
    	return "flight update success";
    }
} 