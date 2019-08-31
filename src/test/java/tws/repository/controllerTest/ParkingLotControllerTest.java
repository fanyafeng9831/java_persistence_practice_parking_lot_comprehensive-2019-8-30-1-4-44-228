package tws.repository.controllerTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import tws.entity.Employee;
import tws.entity.Parkinglot;
import tws.repository.EmployeeMapper;
import tws.repository.ParkingLotMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper ObjectMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }

    @Test
    public void shouldFetchAllParkingLotsWhenSelectAll() throws Exception {
        // given
        jdbcTemplate.execute("INSERT INTO parkinglot VALUES(001 ,10 ,8 ,001);");
        jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES(002 ,10 ,7 ,002);");
        List<Parkinglot> parkingLots = new ArrayList<>();
        parkingLots.add(new Parkinglot(001 ,10 ,8 ,001));
        parkingLots.add(new Parkinglot(002 ,10 ,7 ,002));
        String getString = ObjectMapper.writeValueAsString(parkingLots);

        //when
        this.mockMvc.perform(
                get("/parkinglots")
        )
                //then
                .andDo(print()).andExpect(status().isOk())
                .andExpect(
                        content().json(getString)
                );
    }


    @Test
    public void shouldReturnNotFoundWhenGetErrorUrl() throws Exception {
        // given

        //when
        this.mockMvc.perform(
                get("/parkinglot")
        )
                //then
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldGetAllParkingLotsOneEmployeeWhenGetEmployees() throws Exception {
        //given
        jdbcTemplate.execute("INSERT INTO parkinglot VALUES(001 ,9 ,8 ,001);");
        jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES(002 ,9 ,7 ,002);");
        jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES(003 ,9 ,6 ,001);");
        List<Parkinglot> parkingLots =  new ArrayList<>();
        parkingLots.add(new Parkinglot(001 ,9 ,8 ,001));
        parkingLots.add(new Parkinglot(002 ,9 ,7 ,002));
        String getString = ObjectMapper.writeValueAsString(parkingLots);

        //when
        this.mockMvc.perform(
                get("/employees/2/parkinglots"))
                //then
                .andDo(print()).andExpect(status().isOk())
                .andExpect(
                        content().json(getString)
                );
    }

    @Test
    public void shouldAddOneParkingLotWhenPostParkingLots() throws Exception {
        //given
        Parkinglot parkingLot =  new Parkinglot(003 ,9 ,6 ,001);
        String postString = ObjectMapper.writeValueAsString(parkingLot);
        //when
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/parkinglots")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postString)
        )
                //then
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(
                        content().json(postString)
                );
    }

    @Test
    public void shouldUpdateOneParkingLotWhenPutParkingLots() throws Exception {
        //given
        Parkinglot parkingLot =  new Parkinglot(3,8,3,1);
        String putString = ObjectMapper.writeValueAsString(parkingLot);
        //when
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/parkinglots/{id}",3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(putString)
        )
                //then
                .andDo(print()).andExpect(status().isOk())
                .andExpect(
                        content().json(putString)
                );
    }

    @Test
    public void shouldDeleteOneParkingLotWhenDeleteParkingLots() throws Exception {
        //given

        //when
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/parkinglots/{id}",2)
        )
                //then
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnMethodNotAllowedWhenDeleteErrorUrl() throws Exception {
        //given

        //when
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/parkinglots/")
        )
                //then
                .andDo(print()).andExpect(status().isMethodNotAllowed());
    }

}
