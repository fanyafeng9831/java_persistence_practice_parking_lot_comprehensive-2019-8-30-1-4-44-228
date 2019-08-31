package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Parkinglot;
import tws.repository.ParkingLotMapper;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/parkinglots")

public class ParkingLotController {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Parkinglot> getAll() {
        return parkingLotMapper.selectAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody Parkinglot parkingLot) {
        parkingLotMapper.insertParkingLot(parkingLot);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@PathVariable int id, @RequestBody Parkinglot parkingLot){
    	 parkingLotMapper.updateinsertParkingLot(id,parkingLot);   
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
        parkingLotMapper.deleteinsertParkingLot(id);
    }

}
