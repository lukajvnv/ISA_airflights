package com.airFlights.service.rentacar;

import org.springframework.stereotype.Service;

import com.airFlights.dto.SearchCarDTO;
import com.airFlights.model.user.User;

@Service
public interface CarReservationServ {

	void reserve(SearchCarDTO searchCarDTO, User user) throws Exception;
}
