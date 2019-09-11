package com.airFlights.hotel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.airFlights.dto.hotel.FiltriranaSobaDTO;
import com.airFlights.dto.hotel.HotelDTO;
import com.airFlights.dto.hotel.RezervacijaHotelDTO;
import com.airFlights.dto.hotel.RezervacijaSobaDTO;
import com.airFlights.dto.hotel.SobaDTO;
import com.airFlights.dto.hotel.SobaNaPopustuResponseDTO;
import com.airFlights.dto.hotel.UslugaDTO;
import com.airFlights.TestUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @org.junit.Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
	}
	
    
    @Test
    public void testGetHotel() throws Exception{
        mockMvc.perform(get("/hotel/1")).andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.naziv").value("Maestro"))
                .andExpect(jsonPath("$.promoOpis").value("Maestralni hotel"))
                .andExpect(jsonPath("$.grad").value("Beograd"))
                .andExpect(jsonPath("$.drzava").value("Srbija"))
                .andExpect(jsonPath("$.adresa").value("Pop Lukina 25"))
                .andExpect(jsonPath("$.dodatneUsluge").isArray())
                .andExpect(jsonPath("$.sobe").isArray());
    }

    @Test
    public void testDodajUslugu() throws Exception{
        UslugaDTO usluga = new UslugaDTO();
        usluga.setNaziv("WiFI");
        usluga.setCena(500);
        usluga.setOpis("WiFi jako brz");
        usluga.setPopust(5);

        String json = TestUtilis.json(usluga);
        this.mockMvc.perform(post("/dodajUslugu/1").contentType(contentType).content(json)).andExpect(status().isForbidden());
    }

    @Test
    public void testGetHoteli() throws Exception{
        mockMvc.perform(get("/searchHotel")).andExpect(status().isOk())
                .andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$.[*].naziv").value(hasItem("Maestro")))
                .andExpect(jsonPath("$.[*].naziv").value(hasItem("Grandisimo")))
                .andExpect(jsonPath("$.[*].naziv").value(hasItem("Fantastiko")))
                .andExpect(jsonPath("$.[*].naziv").value(hasItem("Evropa")));
    }

    @Test
    public void testDodajSobu() throws Exception{
        SobaDTO soba = new SobaDTO();
        soba.setBrojKreveta(2);
        soba.setBrojSobe("3");
        soba.setObrisana(false);
        soba.setSprat(2);
        soba.setOpis("Test soba");
        String json = TestUtilis.json(soba);
        mockMvc.perform(post("/dodajSobu/1").contentType(contentType).content(json)).andExpect(status().isOk());
    }

    @Test
    public void testIzmeniHotel() throws Exception{
        HotelDTO izmena = new HotelDTO();
        izmena.setAdresa("Nova adresa");
        izmena.setGrad("Novi grad");
        izmena.setDrzava("Nova drzava");
        izmena.setNaziv("Novi naziv");
        izmena.setPromoOpis("novi opis");

        String json = TestUtilis.json(izmena);
        mockMvc.perform(put("/izmeniHotel/1").contentType(contentType).content(json)).andExpect(status().isOk())
                .andExpect(jsonPath("$.adresa").value("Nova adresa"))
                .andExpect(jsonPath("$.promoOpis").value("novi opis"))
                .andExpect(jsonPath("$.naziv").value("Novi naziv"))
                .andExpect(jsonPath("$.drzava").value("Nova drzava"))
                .andExpect(jsonPath("$.grad").value("Novi grad"));
    }

    @Test
    public void testIzmeniSobu() throws Exception{
        SobaDTO izmena = new SobaDTO();
        izmena.setOpis("Izmenjena");
        izmena.setSprat(3);
        izmena.setBrojSobe("10");
        izmena.setBrojKreveta(3);

        String json = TestUtilis.json(izmena);
        mockMvc.perform(put("/izmeniSobu/1").contentType(contentType).content(json)).andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testRezervacijaSobe() throws Exception{
        RezervacijaHotelDTO rezervacija = new RezervacijaHotelDTO();
        RezervacijaSobaDTO rezervacijaSoba = new RezervacijaSobaDTO();
        ArrayList<UslugaDTO> usluge = new ArrayList<>();
        ArrayList<FiltriranaSobaDTO> sobe = new ArrayList<>();
        rezervacijaSoba.setBrojGostiju(3);
        rezervacijaSoba.setBrojNocenja(3);
        rezervacijaSoba.setCenaPoNocenjuOd(0);
        rezervacijaSoba.setCenaPoNocenjuDo(100000);
        rezervacijaSoba.setDatumDolaska(LocalDate.now());
        UslugaDTO usluga = new UslugaDTO();
        usluga.setPopust(0);
        usluga.setCena(700);
        long id = 4;
        usluga.setId(id);
        usluge.add(usluga);
        FiltriranaSobaDTO sobaF = new FiltriranaSobaDTO();
        long ukupnaCena = 3000;
        sobaF.setUkupnaCena(ukupnaCena);
        SobaDTO soba = new SobaDTO();
        long idSobe = 3;
        soba.setId(idSobe);
        sobaF.setSoba(soba);
        sobe.add(sobaF);
        rezervacija.setPodaci(rezervacijaSoba);
        rezervacija.setSobe(sobe);
        rezervacija.setUsluge(usluge);
        String json = TestUtilis.json(rezervacija);
        this.mockMvc.perform(post("/izvrsiRezervaciju/1/1").contentType(contentType).content(json)).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testBrzaRezervacijaSobe() throws Exception{
        SobaNaPopustuResponseDTO soba = new SobaNaPopustuResponseDTO();
        SobaDTO s = new SobaDTO();
        long idSobe = 3;
        s.setId(idSobe);
        LocalDate danas = LocalDate.now();
        soba.setDatumOd(danas);
        soba.setDatumDo(danas.plusDays(3));
        soba.setSoba(s);
        ArrayList<UslugaDTO> usluge = new ArrayList<>();
        UslugaDTO usluga = new UslugaDTO();
        long idUsluge = 4;
        usluga.setId(idUsluge);
        usluge.add(usluga);
        soba.setUsluge(usluge);
        long idHotela = 1;
        soba.setIdHotela(idHotela);
        soba.setNovaCena(900);
        String json = TestUtilis.json(soba);
        this.mockMvc.perform(post("/brzaRezervacija/1").contentType(contentType).content(json)).andExpect(status().isBadRequest());
    }


}
