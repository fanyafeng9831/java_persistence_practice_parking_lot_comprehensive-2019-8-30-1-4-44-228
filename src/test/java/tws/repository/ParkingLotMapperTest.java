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

import tws.entity.Parkinglot;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {

	@Autowired
    private ParkingLotMapper parkingLotMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Before
    public void clearDB() {
    	JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }
    
    @Test
    public void should_fetch_all_parkinglots_wnen_get_parkinglots() {
        // given
        jdbcTemplate.execute("INSERT INTO parkinglot VALUES(6, 6 ,6,6);");
        // when
        List<Parkinglot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals(1, parkingLotsList.size());
    }
    
    @Test
    public void should_get_parkinglot_when_insert_parkinglot() {
        // given
    	parkingLotMapper.insertParkingLot(new Parkinglot(6, 6, 6,6));
        // when
        List<Parkinglot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals(6, parkingLotsList.get(0).getParkinglotId());
        assertEquals(6, parkingLotsList.get(0).getParkinglotCapacity());
        assertEquals(6, parkingLotsList.get(0).getParkinglotAvailablePositionCount());
    }
    @Test
    public void should_update_parkinglot_when_update_parkinglot() {
        // given
    	parkingLotMapper.updateinsertParkingLot(6,new Parkinglot(7, 7, 7,7));
        // when
        List<Parkinglot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals(7, parkingLotsList.get(0).getParkinglotId());
        assertEquals(7, parkingLotsList.get(0).getParkinglotCapacity());
        assertEquals(7, parkingLotsList.get(0).getParkinglotAvailablePositionCount());
    }
    @Test
    public void should_delete_parkinglot_when_delete_parkinglot() {
        // given
    	parkingLotMapper.deleteinsertParkingLot(7);
        // when
        List<Parkinglot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals(0, parkingLotsList.size());
    }
}
