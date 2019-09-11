package com.airFlights.hotel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.airFlights.model.hotel.Hotel;
import com.airFlights.repository.hotel.HotelRepository;
import com.airFlights.service.hotel.HotelService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {
    @Mock
    private HotelRepository hotelRepositoryMock;

    @InjectMocks
    private HotelService hotelService;

    @Test
    public void testFindOne(){
        Hotel mockHotel = new Hotel("Test hotel", "Srbija", "Novi sad", "Test adresa", "test opis",0L,false);
        mockHotel.setId(11L);
        when(hotelRepositoryMock.getOne(1l)).thenReturn(mockHotel);
        assertEquals(mockHotel, hotelService.findOne(1l));
        verify(hotelRepositoryMock, times(1)).getOne(1l);
        verifyNoMoreInteractions(hotelRepositoryMock);

    }
    @Test
    public void testFindAll(){

        when(hotelRepositoryMock.findAll()).thenReturn(Arrays.asList(new Hotel(), new Hotel(), new Hotel()));
        List<Hotel> lista = hotelService.findAll();
        assertThat(lista).hasSize(3);

        verify(hotelRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(hotelRepositoryMock);
    }

    @Test
    public void testUpdate() {
        Hotel hotelMock = new Hotel("Test hotel", "Srbija", "Novi sad", "Test adresa", "test opis",0L,false);
        when(hotelRepositoryMock.getOne(1l)).thenReturn(hotelMock);
        Hotel dbHotel = hotelService.findOne(1l);

        String newNaziv = "Novi naziv";
        String newOpis = "Novi opis";
        String newGrad = "Novi grad";

        dbHotel.setNaziv(newNaziv);
        dbHotel.setPromoOpis(newOpis);
        dbHotel.setGrad(newGrad);

        when(hotelRepositoryMock.save(dbHotel)).thenReturn(dbHotel);
        dbHotel = hotelService.save(dbHotel);
        assertThat(dbHotel).isNotNull();

        dbHotel = hotelService.findOne(1l);
        assertThat(dbHotel.getNaziv()).isEqualTo(newNaziv);
        assertThat(dbHotel.getGrad()).isEqualTo(newGrad);
        assertThat(dbHotel.getPromoOpis()).isEqualTo(newOpis);
        verify(hotelRepositoryMock, times(2)).getOne(1l);
        verify(hotelRepositoryMock, times(1)).save(dbHotel);
        verifyNoMoreInteractions(hotelRepositoryMock);



    }

}
