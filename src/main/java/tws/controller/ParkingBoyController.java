package tws.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Parkingboy;
import tws.repository.ParkingBoyMapper;

@RestController
@RequestMapping("/parkingboy")

public class ParkingBoyController {
	
	@Autowired
	private ParkingBoyMapper parkingboyMapper;
	
	
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertParkingboy(@RequestBody Parkingboy parkingboy) {
    	String parkingboyID = UUID.randomUUID().toString();
    	parkingboy.setParkingboyId(parkingboyID);
    	parkingboyMapper.insertParkingBoy(parkingboy);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Parkingboy> getAll() {
        return parkingboyMapper.selectAll();
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateParkingboy (@PathVariable String id, @RequestBody Parkingboy parkingboy) {
    	parkingboyMapper.updateParkingboy(id,parkingboy);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteParkingBoy(@PathVariable String id) {
    	parkingboyMapper.deleteParkingBoy(id);
    }
}
