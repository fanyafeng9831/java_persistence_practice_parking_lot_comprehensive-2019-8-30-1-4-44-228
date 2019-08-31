package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tws.entity.Parkinglot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;

@Service
public class parkingLotService {
	@Autowired
	private ParkingLotMapper parkinglotMapper;
	
	 public List<Parkinglot> selectAll(){
	        return parkinglotMapper.selectAll();
	    }
	 
	 public void insertParkingLot(Parkinglot parkingLot) {
		 parkinglotMapper.insertParkingLot(parkingLot);
	    }
	 
	 public void updateinsertParkingLot(int id, Parkinglot parkingLot){
		 parkinglotMapper.updateinsertParkingLot(id,parkingLot);   
    }
	 
	 public void deleteinsertParkingLot( int id) {
		 parkinglotMapper.deleteinsertParkingLot(id);
	    }

}
