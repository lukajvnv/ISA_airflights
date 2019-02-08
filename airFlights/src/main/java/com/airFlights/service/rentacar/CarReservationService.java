package com.airFlights.service.rentacar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.dto.SearchCarDTO;
import com.airFlights.model.CarReservation;
import com.airFlights.model.rentacar.Car;
import com.airFlights.model.user.User;
import com.airFlights.repository.rentacar.CarRepository;
import com.airFlights.repository.rentacar.CarReservationRepository;
import com.airFlights.userService.UserService;

@Service
public class CarReservationService implements CarReservationServ {

	@Autowired
	private CarRepository carRepository;
	
	//@Autowired
	//private UserService userService;
	
	@Autowired
	private CarReservationRepository carReservationRepository;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void reserve(SearchCarDTO searchCarDTO, User user) throws Exception {
		Car car = carRepository.findById(searchCarDTO.getCarId()).get();
		CarReservation carRes = new CarReservation();
		if(car != null && !car.getReserved()) {
				carRepository.save(car);
				car.setReserved(true);
				
				carRes.setCarId(searchCarDTO.getCarId());
				carRes.setCarReservationId(searchCarDTO.getId());
				carRes.setUserId(user.getId());
				carRes.setPickupDate(searchCarDTO.getPickupDate());
				carRes.setDropofDate(searchCarDTO.getDropofDate());
				
				carReservationRepository.save(carRes);
				
				//user.getCarReservations().add(car);
				//userService.save(user);
		}
	}
}
