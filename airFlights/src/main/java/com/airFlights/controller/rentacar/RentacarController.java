package com.airFlights.controller.rentacar;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.rentacar.CarDTO;
import com.airFlights.dto.rentacar.RentaBranchDTO;
import com.airFlights.dto.rentacar.RentacarDTO;
import com.airFlights.model.rentacar.Car;
import com.airFlights.model.rentacar.RentaBranch;
import com.airFlights.model.rentacar.Rentacar;
import com.airFlights.service.rentacar.CarServ;
import com.airFlights.service.rentacar.RentaBranchServ;
import com.airFlights.service.rentacar.RentacarService;

@RestController
@RequestMapping(value = "/rentacar", produces = MediaType.APPLICATION_JSON_VALUE)
public class RentacarController {
	
	@Autowired
	private CarServ carServ;
	
	@Autowired 
	private RentaBranchServ rentaBranchServ;
	
	@Autowired 
	private RentacarService rentacarServ;

	@RequestMapping(method = POST, value = "/addCar", consumes = "application/json")
	public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO) throws InterruptedException {
		
		Car car = new Car();
		
		car.setCarId(carDTO.getCarId());
		car.setReserved(carDTO.getReserved());
		car.setPickupDate(carDTO.getPickupDate());
		car.setDropofDate(carDTO.getDropofDate());
		car.setPickupLocation(carDTO.getPickupLocation());
		car.setDropofLocation(carDTO.getDropofLocation());
		car.setCarName(carDTO.getCarName());
		car.setCarBrand(carDTO.getCarBrand());
		car.setCarModel(carDTO.getCarModel());
		car.setCarYear(carDTO.getCarYear());
		car.setNumberOfSeats(carDTO.getNumberOfSeats());
		car.setPrice(carDTO.getPrice());
		
		car = carServ.save(car);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = POST, value = "/addRentaBranch", consumes = "application/json")
	public ResponseEntity<RentaBranchDTO> saveRentaBranch(@RequestBody RentaBranchDTO rentaBranchDTO) throws InterruptedException {
		
		RentaBranch rentaBranch = new RentaBranch();
		
		rentaBranch.setBranchId(rentaBranchDTO.getBranchId());
		rentaBranch.setName(rentaBranchDTO.getName());
		rentaBranch.setLocation(rentaBranchDTO.getLocation());
		
		rentaBranch = rentaBranchServ.save(rentaBranch);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RentacarDTO>> getAllRentacars() {
		List<Rentacar> rentacars = rentacarServ.findAll();
		
		List<RentacarDTO> answer = new ArrayList<RentacarDTO>();
		for(Rentacar rentacar : rentacars) {
			/*RentacarDTO rentacarDTO = new RentacarDTO();
			rentacarDTO.setName(rentacar.getName());
			rentacarDTO.setAdress(rentacar.getAdress());
			rentacarDTO.setPromoDescription(rentacar.getPromoDescription());
			rentacarDTO.setRentacarId(rentacar.getRentacarId());
			rentacarDTO.setAvgRating(rentacar.getAvgRating());
			rentacarDTO.setRatingNumber(rentacar.getRatingNumber());
			rentacarDTO.setIncome(rentacar.getIncome());
			//rentacarDTO.setCars(rentacar.getCars());
			rentacarDTO.setBranches(rentacar.getBranches());*/
			
			answer.add(new RentacarDTO(rentacar));
		}
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RentacarDTO> getRentacarById(@PathVariable("id") Integer index){
		
		Rentacar rentacar = rentacarServ.findRentacarById(index);
		if(rentacar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		/*RentacarDTO rentacarDTO = new RentacarDTO();
		rentacarDTO.setName(rentacar.getName());
		rentacarDTO.setAdress(rentacar.getAdress());
		rentacarDTO.setPromoDescription(rentacar.getPromoDescription());
		rentacarDTO.setRentacarId(rentacar.getRentacarId());
		rentacarDTO.setAvgRating(rentacar.getAvgRating());
		rentacarDTO.setRatingNumber(rentacar.getRatingNumber());
		rentacarDTO.setIncome(rentacar.getIncome());
		//rentacarDTO.setCars(rentacar.getCars());
		//rentacarDTO.setBranches(rentacar.getBranches());*/
		
		return new ResponseEntity<>(new RentacarDTO(rentacar) , HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteRentacar(@PathVariable("id") Integer index){
		try {
			rentacarServ.removeRentacar(index);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Obrisan", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateRentacar(@RequestBody RentacarDTO rentacarDTO){
		Rentacar rentacar = rentacarServ.findRentacarById(rentacarDTO.getRentacarId()); 
			
		if (rentacar == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		rentacarServ.updateRentacar(rentacar, rentacarDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/branches/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RentaBranchDTO>> getRentaBranches(@PathVariable("id") Integer index){
		
		Rentacar rentacar = rentacarServ.findRentacarById(index);
		if(rentacar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Set<RentaBranch> rentaBranches = rentacar.getBranches();
		
		List<RentaBranchDTO> branches = new ArrayList<RentaBranchDTO>();
		for(RentaBranch rb: rentaBranches) {	
			branches.add(new RentaBranchDTO(rb));
		}
		
		return new ResponseEntity<>(branches, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/newBranch/{id}", method = RequestMethod.POST)
	public ResponseEntity<String> addBranchToRentacar(@RequestBody RentaBranch rentaBranch, @PathVariable("id") Integer index){
		Rentacar rentacar = rentacarServ.findRentacarById(index);
		rentaBranch.setRentacar(rentacar);
		rentacarServ.addNewBranch(rentaBranch);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
