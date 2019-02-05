package com.airFlights.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.airFlights.dto.rentacar.CarDTO;
import com.airFlights.model.rentacar.Car;
import com.airFlights.repository.rentacar.CarRepository;

@Service
public class CarService implements CarServ{

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
	
	public void removeCar(Integer id) {
		carRepository.deleteById(id);
	}
	
	public Car save(Car car) {
		return carRepository.save(car);
	}
	
	public void updateCar(Car car, CarDTO carDTO) {
		car.setCarBrand(carDTO.getCarBrand());
		car.setCarModel(carDTO.getCarModel());
		car.setCarName(carDTO.getCarName());
		car.setCarYear(carDTO.getCarYear());
		
		//filijale, kola i cene
		
		carRepository.save(car);
	}

	@Override
	public Car findById(Long id) throws AccessDeniedException {
		return carService.findById(id);
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}
	
	
}
