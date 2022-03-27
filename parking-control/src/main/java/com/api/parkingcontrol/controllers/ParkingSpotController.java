package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.ParkinSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController
@CrossOrigin(origins ="*", maxAge=3600)
@RequestMapping ("/parking-spot")
public class ParkingSpotController {
	final ParkingSpotService parkingSpotService;

	public ParkingSpotController(ParkingSpotService parkingSpotService) {
	
		this.parkingSpotService = parkingSpotService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkinSpotDto parkingSpotDto ){
		if(parkingSpotService.existByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car in Use!");
		}
		if(parkingSpotService.existByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot number in use!");
		}
		
		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return  ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
	}
    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
    	return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }
    @GetMapping ("/{licenseplatecar}")
    public  ResponseEntity<Object> getByLicensePlateCar(@PathVariable(value="licenseplatecar") String licenseplatecar){
    	Optional <ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findAllLicensePlateCar(licenseplatecar);
    	if (!parkingSpotModelOptional.isPresent()) {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("License plate Car not present");
    	}
    	return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }
    
    @DeleteMapping ("/{licenseplatecar}")
    public  ResponseEntity<Object> deleteByLicensePlateCar(@PathVariable(value="licenseplatecar") String licenseplatecar){
    	Optional <ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findAllLicensePlateCar(licenseplatecar);
    	if (!parkingSpotModelOptional.isPresent()) {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("License plate Car not present");
    	}
    	parkingSpotService.delete(parkingSpotModelOptional.get());
    	return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted sucessfully");
    }
    
    @PutMapping ("/{licenseplatecar}")
    public  ResponseEntity<Object> updateByLicensePlateCar(@PathVariable(value="licenseplatecar") String licenseplatecar, @RequestBody @Valid ParkinSpotDto parkingSpotDto) {
    	Optional <ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findAllLicensePlateCar(licenseplatecar);
    	if (!parkingSpotModelOptional.isPresent()) {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("License plate Car not present");
    	}
    	  var parkingSpotModel = new ParkingSpotModel();
          BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
          parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
          parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
          return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    }
}