package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.Parkingboy;

@Mapper
public interface ParkingBoyMapper {
	@Select("select * from parkingBoy;")
	List<Parkingboy> selectAll();
	
	@Insert("insert into parkingboy (parkingboyId,name,parkingboyAge)\r\n" + 
			"	values\r\n" + 
			"	(#{parkingboy.parkingboyId},#{parkingboy.name},#{parkingboy.parkingboyAge})")
    void insertParkingBoy(@Param("parkingboy") Parkingboy parkingboy);
	
	@Update("update parkingboy set Parkingboy.name=#{parkingBoy.name},Parkingboy.parkingboyAge=#{parkingBoy.parkingboyAge} where Parkingboy.parkingboyId=#{parkingBoyId};")
	void updateParkingboy(@Param("parkingBoyId") String parkingBoyId, @Param("parkingBoy") Parkingboy parkingboy);
	
	@Delete("delete from parkingboy where Parkingboy.parkingboyId=#{parkingBoysId};")
    void deleteParkingBoy(@Param("parkingBoysId") String parkingBoysId);
}