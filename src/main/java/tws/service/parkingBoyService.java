package tws.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tws.entity.Parkingboy;
import tws.repository.ParkingBoyMapper;

@Service
public class parkingBoyService {
	
	@Autowired
	private ParkingBoyMapper parkingboyMapper;

    public List<Parkingboy> selectAll(){
        return parkingboyMapper.selectAll();
    }
    
    public void insertParkingboy(Parkingboy parkingboy) {
    	String parkingboyID = UUID.randomUUID().toString();
    	parkingboy.setParkingboyId(parkingboyID);;
    	parkingboyMapper.insertParkingBoy(parkingboy);
    }
    
    public void updateParkingboy ( String id, Parkingboy parkingboy) {
    	parkingboyMapper.updateParkingboy(id,parkingboy);
    }
    
    public void deleteParkingBoy( String id) {
    	parkingboyMapper.deleteParkingBoy(id);
    }
}
