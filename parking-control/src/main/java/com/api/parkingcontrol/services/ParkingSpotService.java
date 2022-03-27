package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	
	final ParkingSpotRepository parkingSpotRepository;

	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}
	 @Transactional
	 public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		 return parkingSpotRepository.save(parkingSpotModel);
	 }
	
	public boolean existByLicensePlateCar(String licensePlateCar) {
		
		return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}
	public boolean existByParkingSpotNumber(String parkingSpotNumber) {
		
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}
	public List<ParkingSpotModel> findAll() {
		return parkingSpotRepository.findAll();
	}
	public Optional<ParkingSpotModel> findAllLicensePlateCar(String licensePlateCar) {
		return parkingSpotRepository.findByLicensePlateCar(licensePlateCar);
	}
	@Transactional 
	public void delete(ParkingSpotModel parkingSpotModel) {
		parkingSpotRepository.delete(parkingSpotModel);
	}
	public void update(ParkingSpotModel parkingSpotModel) {
		
		
	}
	
}
