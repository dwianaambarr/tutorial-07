package com.apap.tu07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu07.model.FlightModel;
import com.apap.tu07.repository.FlightDb;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;

    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
	public Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber) {
		Optional<FlightModel> flight = flightDb.findByFlightNumber(flightNumber);
		return flight;
	}

    @Override
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);	
	}

    @Override
	public FlightModel getFlightDetailById(long id) {
		return flightDb.findById(id).get();
	}

    @Override
	public List<FlightModel> getListFlight() {
		return flightDb.findAll();
	}

    @Override
    public FlightModel getFlightById(long id) {
    	return flightDb.findById(id).get();
    }

    @Override
    public void updateFlight (long id, FlightModel flight) {
    	FlightModel oldFlight = this.getFlightById(id);
		oldFlight.setDestination(oldFlight.getDestination());
		oldFlight.setOrigin(oldFlight.getOrigin());
		oldFlight.setTime(oldFlight.getTime());
    }

} 