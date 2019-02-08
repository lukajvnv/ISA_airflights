package com.airFlights.service.avio;

import static com.airFlights.constants.AirlineConstants.AIRLINE_1_ADDRESS;
import static com.airFlights.constants.AirlineConstants.AIRLINE_1_CITY;
import static com.airFlights.constants.AirlineConstants.AIRLINE_1_DESC;
import static com.airFlights.constants.AirlineConstants.AIRLINE_1_ID;
import static com.airFlights.constants.AirlineConstants.AIRLINE_1_LUGGAGE;
import static com.airFlights.constants.AirlineConstants.AIRLINE_1_NAME;
import static com.airFlights.constants.AirlineConstants.AIRLINE_2_ADDRESS;
import static com.airFlights.constants.AirlineConstants.AIRLINE_2_CITY;
import static com.airFlights.constants.AirlineConstants.AIRLINE_2_DESC;
import static com.airFlights.constants.AirlineConstants.AIRLINE_2_ID;
import static com.airFlights.constants.AirlineConstants.AIRLINE_2_LUGGAGE;
import static com.airFlights.constants.AirlineConstants.AIRLINE_2_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.airFlights.model.avio.Airline;
import com.airFlights.repository.avio.AirlineRepository;
import com.airFlights.repository.avio.DestinationRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AirlineServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Mock
	private AirlineRepository airlineRepositoryMock;
	
	@Mock
	private DestinationRepository destinationRepositoryMock;
	
	@InjectMocks
	private AirlineService airlineService;

	@Mock
	private Airline airlineMock;
	
	
	@Test
	public void testFindAllAirlines() {
		when(airlineRepositoryMock.findAllByOrderByName()).thenReturn(Arrays.asList(new Airline(AIRLINE_1_ID, AIRLINE_1_NAME, AIRLINE_1_ADDRESS, AIRLINE_1_CITY, AIRLINE_1_DESC, AIRLINE_1_LUGGAGE)
				));
		List<Airline> airline = airlineService.findAllAirlines();
		assertThat(airline).hasSize(1);
		
		verify(airlineRepositoryMock, times(1)).findAllByOrderByName();
        verifyNoMoreInteractions(airlineRepositoryMock);
        
        
	}

	@Test
	public void testFindAirlineById() {
//		Airline airline = new Airline(AIRLINE_2_ID, AIRLINE_2_NAME, AIRLINE_2_ADDRESS, AIRLINE_2_CITY, AIRLINE_2_DESC, AIRLINE_2_LUGGAGE);
//		
//		Optional<Airline> r = Optional.of(airline);
//		Mockito.<Optional<Airline>>when(airlineRepositoryMock.findById(AIRLINE_2_ID)).thenReturn(r);
//
//		
//		//String returnCacheValueString = "lol";
//		//Optional<Object> returnCacheValue = Optional.of((Object) returnCacheValueString);
//		//Mockito.<Optional<Object>>when(remotestore.get("cache-name", "cache-key")).thenReturn(returnCacheValue);
//		
//		//when(airlineRepositoryMock.findById(AIRLINE_2_ID)).thenReturn(Optional.of(airline));
//		Mockito.<Airline>when(airlineRepositoryMock.findById(AIRLINE_2_ID).get()).thenReturn(airline);
//		Airline airlineReturn = airlineService.findAirlineById(AIRLINE_2_ID);
//		assertThat(airlineReturn).isNotNull();
//		
////		assertThat(dbStudent.getId()).isEqualTo(1L);
////		assertThat(dbStudent.getFirstName()).isEqualTo(DB_FIRST_NAME);
////        assertThat(dbStudent.getLastName()).isEqualTo(DB_LAST_NAME);
////        assertThat(dbStudent.getIndex()).isEqualTo(DB_INDEX);
//        
//        //verify(airlineRepositoryMock, times(1)).findById(AIRLINE_2_ID).get();
//        verifyNoMoreInteractions(airlineRepositoryMock);
	}
//
//	@Test
//	public void testGetQuickTickets() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateAirline() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddNewDestination() {
//		fail("Not yet implemented");
//	}

}
