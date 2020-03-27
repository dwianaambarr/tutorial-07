package com.apap.tu07.service;

import java.util.List;
import java.util.Optional;

import com.apap.tu07.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
	FlightModel addFlight(FlightModel flight);
	Optional<FlightModel> getFlightDetailByFlightNumber (String flightNumber);
	void deleteFlight(FlightModel flight);
	FlightModel getFlightDetailById(long id);
	List<FlightModel> getListFlight();
	FlightModel getFlightById(long flightId);
	void updateFlight (long id, FlightModel flight);
} 