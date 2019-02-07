package com.airFlights.controller.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.rentacar.RentaBranchDTO;
import com.airFlights.model.rentacar.RentaBranch;
import com.airFlights.service.rentacar.RentaBranchService;

@RestController
@RequestMapping("/rentabranch")
public class RentacarBranchController {
	
	@Autowired
	private RentaBranchService rentaBranchService;

	@RequestMapping(path = "/getAllBranches", method = RequestMethod.GET)
	public ResponseEntity<List<RentaBranchDTO>> getAllBranches(){
		List<RentaBranch> branches = rentaBranchService.findAll();
		
		List<RentaBranchDTO> answer = new ArrayList<RentaBranchDTO>();
		for(RentaBranch rb: branches) {
			answer.add(new RentaBranchDTO(rb));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/*@RequestMapping(path = "/remove/{id}", method = RequestMethod.POST)
	public ResponseEntity<List<RentaBranchDTO>> removeBranch(@RequestBody RentaBranchDTO rentaBranchDTO, @PathVariable("id") Integer index){
		List<RentaBranch> rentabranches = rentaBranchService.findAll();
		
		for(RentaBranch rb : rentabranches) {
			if(rb.getRentacar().getRentacarId() == index) {
				System.out.println("JESI USAO?");
				rb.setRentacar(null);
				rentaBranchService.save(rb);
			}
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}*/

}
