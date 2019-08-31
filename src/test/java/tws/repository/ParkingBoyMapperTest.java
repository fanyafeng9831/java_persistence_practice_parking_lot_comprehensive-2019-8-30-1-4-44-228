package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Parkingboy;
import tws.entity.Parkinglot;

public class ParkingBoyMapperTest {
	@RunWith(SpringRunner.class)
	@MybatisTest
	public class ParkingLotMapperTest {

		@Autowired
	    private ParkingBoyMapper parkingBoyMapper;

	    JdbcTemplate jdbcTemplate;

	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    @Before
	    public void clearDB() {
	    	JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingBoy");
	    }

	    @After
	    public void tearDown() throws Exception {
	        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingBoy");
	    }
	    
	    @Test
	    public void should_fetch_all_parkingboys_wnen_get_parkingboysList() {
	        // given
	        jdbcTemplate.execute("INSERT INTO parkingBoy VALUES('1', 'weitaming' ,18);");
	        // when
	        List<Parkingboy> parkingboysList = parkingBoyMapper.selectAll();
	        // then
	        assertEquals(1, parkingboysList.size());
	    }
	    
	    @Test
	    public void should_get_parkingBoy_when_insert_parkingBoy() {
	        // given
	    	parkingBoyMapper.insertParkingBoy(new Parkingboy("2","weitaming" , 25));
	        // when
	        List<Parkingboy> parkingboysList = parkingBoyMapper.selectAll();
	        // then
	        assertEquals(2, parkingboysList.get(1).getParkingboyId());
	        assertEquals("weitaming", parkingboysList.get(1).getName());
	        assertEquals(25, parkingboysList.get(1).getParkingboyAge());
	    }

	

    @Test
    public void should_get_parkingBoy_when_update_parkingBoy() {
        // given
    	parkingBoyMapper.updateParkingboy("2",new Parkingboy("2","改变后名字" , 25));
        // when
        List<Parkingboy> parkingboysList = parkingBoyMapper.selectAll();
        // then
        assertEquals("改变后名字", parkingboysList.get(1).getName());
        assertEquals(25, parkingboysList.get(1).getParkingboyAge());
    }
    
    @Test
    public void should_delete_parkingBoy_when_delete_parkingBoy() {
        // given
    	parkingBoyMapper.deleteParkingBoy("2");
        // when
    	List<Parkingboy> parkingboysList = parkingBoyMapper.selectAll();
        // then
        assertEquals(1, parkingboysList.size());
    }
	}
}
