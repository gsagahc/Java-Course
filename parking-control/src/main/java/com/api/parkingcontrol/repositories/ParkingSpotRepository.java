package com.api.parkingcontrol.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.models.ParkingSpotModel;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{
	
	 boolean existsByLicensePlateCar(String licensePlateCar) ;
	 boolean existsByParkingSpotNumber(String parkingSpotNumber);
	 Optional<ParkingSpotModel> findByLicensePlateCar(String licensePlateCar);
	 Optional<ParkingSpotModel> deleteByLicensePlateCar(String licensePlateCar);	 
	

}
