package tws.repository;

import org.apache.ibatis.annotations.*;
import tws.entity.Parkinglot;
import java.util.List;

@Mapper

public interface ParkingLotMapper {

    @Select("select * from parkinglot;")
    List<Parkinglot> selectAll();

    @Insert("insert into parkinglot values (#{parkinglot.parkinglotId}, #{parkinglot.parkinglotCapacity}, #{parkinglot.parkinglotAvailablePositionCount}, #{parkinglot.parkingboyId});")
    void insertParkingLot(@Param("parkinglot") Parkinglot parkinglot);

    @Update("update parkinglot set parkinglot.parkinglotCapacity=#{parkinglot.parkinglotCapacity}, parkinglot.parkinglotAvailablePositionCount=#{parkinglot.parkinglotAvailablePositionCount} where parkinglot.parkingboyId = #{parkingboyId};")
    void updateinsertParkingLot(@Param("parkingboyId") int parkingBoyId, @Param("parkinglot") Parkinglot parkinglot);

    @Delete("delete from parkinglot where parkinglot.parkingboyId #{parkingBoysId};")
    void deleteinsertParkingLot(@Param("parkingBoysId") int parkingBoysId);
}
