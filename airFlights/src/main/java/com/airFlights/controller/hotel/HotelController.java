package com.airFlights.controller.hotel;


import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.airFlights.dto.hotel.*;
import com.airFlights.model.hotel.*;
import com.airFlights.model.user.User;
import com.airFlights.service.hotel.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@RestController
@RequestMapping(value = "/hoteli")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private UslugaService uslugaService;
    @Autowired
    private SobaService sobaService;
    @Autowired
    private CenaNocenjaService cenaNocenjaService;
    @Autowired
    private ZauzetostSobeService zauzetostSobeService;
    @Autowired
    private RezervacijaHotelaService rezervacijaHotelaService;
    @Autowired
    private SobaNaPopustuService sobePopustService;

    //@CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/getHotel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelDTO> getHotel(@PathVariable("id") Long id, HttpSession session){



        Hotel h = hotelService.findOne(id);
        if(h == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


        return new ResponseEntity<>(new HotelDTO(h), HttpStatus.OK);
    }

    @RequestMapping(value = "/getHotelnk/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelDTO> getHotelnk(@PathVariable("id") Long id){
        Hotel h = hotelService.findOne(id);
        
        if(h == null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        else{
            return new ResponseEntity<>(new HotelDTO(h), HttpStatus.OK);
        }
    }
   // @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/getHoteli", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<HotelDTO>> getHoteli(){
        ArrayList<Hotel> hoteli = new ArrayList<>(hotelService.findAll());
        ArrayList<HotelDTO> hoteliDTO = new ArrayList<>();
        for(Hotel h : hoteli){
            hoteliDTO.add(new HotelDTO(h));
        }
        return new ResponseEntity<>(hoteliDTO, HttpStatus.OK);
    }

   // @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/dodajUslugu/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<UslugaDTO> dodajUslugu(@RequestBody UslugaDTO uslugaDTO, @PathVariable("id") Long id){

        Hotel h = hotelService.findOne(id);
        uslugaDTO.setHotel(h);
        Usluga usluga = this.uslugaService.save(new Usluga(uslugaDTO));
        return new ResponseEntity<>(uslugaDTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/getUsluga/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UslugaDTO> getUsluga(@PathVariable("id") Long id, HttpSession session){

        Usluga us = uslugaService.findOne(id);
        Hotel h = us.getHotel();
        if(h == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


        return new ResponseEntity<>(new UslugaDTO(us), HttpStatus.OK);
    }

    @RequestMapping(value = "/izmeniUslugu/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<UslugaDTO> izmeniUslugu(@RequestBody UslugaDTO uslugaDTO, @PathVariable("id") Long id, HttpSession session){


        Usluga u = uslugaService.findOne(id);
        Hotel h = u.getHotel();

        if(h == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


        u.setCena(uslugaDTO.getCena());
        u.setNaziv(uslugaDTO.getNaziv());
        u.setOpis(uslugaDTO.getOpis());
        u.setPopust(uslugaDTO.getPopust());
        uslugaService.save(u);
        return new ResponseEntity<>(uslugaDTO,HttpStatus.OK);
    }
    @RequestMapping(value = "/izbrisiUslugu/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<UslugaDTO> izbrisiUslugu(@PathVariable("id") Long id, HttpSession session){



        Usluga u = uslugaService.findOne(id);
        Hotel h = u.getHotel();

        if(h == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }




        u.setObrisana(true);
        uslugaService.save(u);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/dodajSobu/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<SobaDTO> dodajSobu(@RequestBody SobaDTO sobaDTO, @PathVariable("id") Long id){
        Hotel h = hotelService.findOne(id);
        sobaDTO.setHotel(h);
        sobaDTO.setObrisana(false);
        Soba soba = this.sobaService.save(new Soba(sobaDTO));
        return new ResponseEntity<>(sobaDTO,HttpStatus.OK);
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/izbrisiSobu/{id}",method = RequestMethod.DELETE)
    public void izbrisiSobu(@PathVariable("id") Long id){
        //Soba s = sobaService.findOne(id);
        //sobaService.delete(s);
        String flag = "Soba uspesno obrisana!";
        LocalDate danas = LocalDate.now();
        List<ZauzetostSobe> rezSobe = zauzetostSobeService.findZauzetostZaSobuOdDatuma(id, danas);
        if(rezSobe.size() != 0){
            flag = "Soba je rezervisana, ne mozete je obrisati!";

        }
        else{
            sobaService.deleteLogical(id);

        }

    }
   // @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/izmeniSobu/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void izmeniSobu(@RequestBody SobaDTO sobaDTO, @PathVariable("id") Long id){

        String flag = "Soba uspesno izmenjena!";
        LocalDate danas = LocalDate.now();
        List<ZauzetostSobe> rezSobe = zauzetostSobeService.findZauzetostZaSobuOdDatuma(id, danas);
        if(rezSobe.size() != 0){
            flag = "Soba je rezervisana, ne mozete je izmeniti!";

        }
        else{
            sobaDTO.setId(id);
            int res = this.sobaService.update(sobaDTO);
            System.out.println("Izmenjeno soba: " + res);

        }
    }

    //@CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/getSoba/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SobaDTO> getSoba(@PathVariable("id") Long id){
        Soba s = sobaService.findOne(id);
        //TODO vidi je l treba da vratis samo one koje nisu izbrisane
        return new ResponseEntity<>(new SobaDTO(s), HttpStatus.OK);
    }

   // @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/dodajCenuNocenja/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<CenaNocenjaDTO> dodajCenuNocenja(@RequestBody CenaNocenjaDTO cenaNocenjaDTO, @PathVariable("id") Long id){

        Soba s = sobaService.findOne(id);
        cenaNocenjaDTO.setSoba(s);
        String flag = "";
        if(cenaNocenjaDTO.getDoDatuma().isAfter(cenaNocenjaDTO.getOdDatuma())){
            for(CenaNocenja cn : s.getCeneNocenja()){
                if(cenaNocenjaDTO.getOdDatuma().isAfter(cn.getOdDatuma()) && cenaNocenjaDTO.getOdDatuma().isBefore(cn.getDoDatuma())){
                    flag = "Preklapanje zeljenog intervala sa već postojećim intervalom:  " + cn.getOdDatuma() + " : " + cn.getDoDatuma();
                    break;
                }
                if(cenaNocenjaDTO.getDoDatuma().isAfter(cn.getOdDatuma()) && cenaNocenjaDTO.getDoDatuma().isBefore(cn.getDoDatuma())){
                    flag = "Preklapanje zeljenog intervala sa već postojećim intervalom:  " + cn.getOdDatuma() + " : " + cn.getDoDatuma();
                    break;
                }
                if(cenaNocenjaDTO.getOdDatuma().isBefore(cn.getOdDatuma()) && cenaNocenjaDTO.getDoDatuma().isAfter(cn.getOdDatuma())){
                    flag = "Preklapanje zeljenog intervala sa već postojećim intervalom:  " + cn.getOdDatuma() + " : " + cn.getDoDatuma();
                    break;
                }

            }
        }
        else{
            flag = "Datum do koga važi cena mora biti manji od datuma od koga važi cena!";
        }
        if(flag.equals("")) {
            CenaNocenja cenaNocenja = this.cenaNocenjaService.save(new CenaNocenja(cenaNocenjaDTO));
            return new ResponseEntity<>(new CenaNocenjaDTO(cenaNocenja), HttpStatus.OK);
        }
        else{
            System.out.println(flag);
            return new ResponseEntity<>(new CenaNocenjaDTO(),HttpStatus.FORBIDDEN);
        }
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getSobeZaRezervaciju/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ArrayList<FiltriranaSobaDTO>> getSobeZaRezervaciju(@RequestBody RezervacijaSobaDTO rezervacijaSobaDTO, @PathVariable("id") Long id){

        LocalDate sad = LocalDate.now();
        if(rezervacijaSobaDTO.getDatumDolaska().isBefore(sad)){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
        }
        if(rezervacijaSobaDTO.getBrojNocenja() <= 0 || rezervacijaSobaDTO.getBrojGostiju() <=0){

            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
        }
        ArrayList<FiltriranaSobaDTO> retVal = new ArrayList<>();
        Hotel h = hotelService.findOne(id);
        Set<Soba> sobe = h.getSobe();
        List<SobaNaPopustu> sveSobeNaPopustu = sobePopustService.findSveSobeZaHotel(h.getId());
        List<SobaNaPopustu> sobeNaPopustuDatBoravka = new ArrayList<>();
        LocalDate datumDolaska = rezervacijaSobaDTO.getDatumDolaska();
        LocalDate datumOdlaska = datumDolaska.plusDays(rezervacijaSobaDTO.getBrojNocenja());
        int cenaMin = rezervacijaSobaDTO.getCenaPoNocenjuOd(); //ukupna cena ipak
        int cenaMax = Integer.MAX_VALUE; //ukupna cena ipak
        if(rezervacijaSobaDTO.getCenaPoNocenjuDo() > 0){
           cenaMax =  rezervacijaSobaDTO.getCenaPoNocenjuDo();
        }

        Set<Soba> slobodneSobe = new HashSet<>();

        for(SobaNaPopustu sp : sveSobeNaPopustu){
            System.out.println("Soba IMA NEKAD POPUST " + sp.getSoba().getId());
            if(datumOdlaska.isBefore(sp.getDoDatuma()) && datumOdlaska.isAfter(sp.getOdDatuma())){
                System.out.println("Soba na popustu u ovom periodu: " + sp.getId());
                sobeNaPopustuDatBoravka.add(sp);
            }

            else if(datumOdlaska.isAfter(sp.getDoDatuma()) && datumDolaska.isBefore(sp.getDoDatuma())){
                System.out.println("Soba na popustu u ovom periodu: " + sp.getId());
                sobeNaPopustuDatBoravka.add(sp);
            }
            else if(datumDolaska.isBefore(sp.getOdDatuma()) && datumOdlaska.isAfter(sp.getOdDatuma())){
                System.out.println("Soba na popustu u ovom periodu: " + sp.getId());
                sobeNaPopustuDatBoravka.add(sp);
            }
        }


        for(Soba s: sobe){
            List<ZauzetostSobe> zauzetost = zauzetostSobeService.findZauzetostZaSobuOdDatuma(s.getId(),datumDolaska);
            if(zauzetost == null){
                System.out.println("Zauzetost je null!");
                slobodneSobe.add(s);
            }
            else{
                boolean zauzeta = false;
                for(ZauzetostSobe z : zauzetost){
                    //14 pre 14 - nije
                    if(datumOdlaska.isBefore(z.getDoDatuma().plusDays(1)) && datumOdlaska.isAfter(z.getOdDatuma())){
                        zauzeta = true;
                        break;
                    }
                    //14 posle 13 - jeste, 11 pre 13 - jeste
                    if(datumOdlaska.isAfter(z.getDoDatuma()) && datumDolaska.isBefore(z.getDoDatuma())){
                        zauzeta = true;
                        break;
                    }

                }
                if(!zauzeta){
                    slobodneSobe.add(s);
                }
            }
        }

        if(slobodneSobe.size()>0) {
            for (Soba s : slobodneSobe) {
              
                ArrayList<LocalDate> datumi = new ArrayList<>();
                long ukupnaCena = 0;
                long i = 0;
                LocalDate noviDatum = null;
                do{
                    noviDatum = datumDolaska.plusDays(i);
                    if(noviDatum.isEqual(datumOdlaska)){
                        break;
                    }
                    else{
                        CenaNocenja cena = cenaNocenjaService.getCenaNocenjaZaDatum(noviDatum,s.getId());
                        if(cena!=null){
                            ukupnaCena+= cena.getCena();
                        }
                        else{
                            //nema definisana cena za zeljeni datum
                            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                        }

                    }
                    i++;
                }while(noviDatum.isBefore(datumOdlaska));

                if (ukupnaCena >= cenaMin && ukupnaCena <= cenaMax) {
                    float prosecnaOcena = 0;
                    float sum = 0;
                    for(OcenaSoba o : s.getOcene()){
                        sum+=o.getOcena();
                    }
                    if(s.getOcene().size()>0){
                        prosecnaOcena = sum/s.getOcene().size();
                    }

                    retVal.add(new FiltriranaSobaDTO(new SobaDTO(s), ukupnaCena, prosecnaOcena));
                }

            }
        }
        else{
            //Nema slobodnih soba
            System.out.println("Nema slobodnih soba!");
        }
      

        Iterator<FiltriranaSobaDTO> it = retVal.iterator();
        for(SobaNaPopustu sp : sobeNaPopustuDatBoravka){
            while(it.hasNext()){
                FiltriranaSobaDTO fs = it.next();
                if(fs.getSoba().getId() == sp.getSoba().getId()){
                    System.out.println("IZBACUJEM SOBU: " + sp.getId());
                    it.remove();
                }
            }
        }
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
   // @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/getUslugeHotela/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<UslugaDTO>> getUslugeHotela(@PathVariable("id") Long id){
        Hotel h = hotelService.findOne(id);
        ArrayList<UslugaDTO> retVal = new ArrayList<>();
        for(Usluga u : h.getDodatneUsluge()){
            retVal.add(new UslugaDTO(u));
        }
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

   // @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/izvrsiRezervaciju/{id}/{idGlavne}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<RezervacijaHotelDTO> izvrsiRezervaciju(@RequestBody RezervacijaHotelDTO rezervacijaDTO, @PathVariable("id") Long id, @PathVariable("idGlavne") Long idGlavne){

        long ukupnaCenaRezervacije =  0;
        long ukupanPopust = 0;
        Set<ZauzetostSobe> zauzetostiSoba = new HashSet<>();
        for(FiltriranaSobaDTO fs : rezervacijaDTO.getSobe()){
            Soba soba = sobaService.findOne(fs.getSoba().getId());
            zauzetostiSoba.add(new ZauzetostSobe(rezervacijaDTO.getPodaci().getDatumDolaska(),rezervacijaDTO.getPodaci().getDatumDolaska().plusDays(rezervacijaDTO.getPodaci().getBrojNocenja()),soba));
        }
        Set<Usluga> usluge = new HashSet<>();
        for(UslugaDTO usluga : rezervacijaDTO.getUsluge()){
            usluge.add(uslugaService.findOne(usluga.getId()));
            ukupnaCenaRezervacije+=usluga.getCena();
            //MAKSIMALAN POPUST DO 20%
            if(ukupanPopust + usluga.getPopust()<=20){
                ukupanPopust+=usluga.getPopust();
            }
            else{
                ukupanPopust = 20;
            }

        }


        for(FiltriranaSobaDTO fs : rezervacijaDTO.getSobe()){
            ukupnaCenaRezervacije+=fs.getUkupnaCena();
        }

        double ukupnaCenaSaPopustom = ukupnaCenaRezervacije;
        if(ukupanPopust>0){
            double percentage = ukupanPopust * 0.01;
            ukupnaCenaSaPopustom = ukupnaCenaRezervacije - ukupnaCenaRezervacije*percentage;
        }
        BigDecimal bd = new BigDecimal(ukupnaCenaSaPopustom);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        ukupnaCenaSaPopustom = bd.doubleValue();
        RezervacijaHotela rezervacija = new RezervacijaHotela(zauzetostiSoba,usluge, ukupnaCenaSaPopustom, rezervacijaDTO.getPodaci().getDatumDolaska(),rezervacijaDTO.getPodaci().getDatumDolaska().plusDays(rezervacijaDTO.getPodaci().getBrojNocenja()),id,rezervacijaDTO.getPodaci().getBrojGostiju());
        rezervacijaHotelaService.save(rezervacija);
        /*RezervacijaLeta let = letService.findOne(idGlavne);
        let.setRezervacijaHotela(rezervacija);
        letService.save(let);*/

        return new ResponseEntity<>(rezervacijaDTO,HttpStatus.OK);
    }

   // @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/dodajSobuNaPopustu/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<SobaNaPopustuDTO> dodajSobuNaPopustu(@RequestBody SobaNaPopustuDTO sobaDTO, @PathVariable("id") Long idHotela){

        List<SobaNaPopustu> sviPopustiZaSobu = sobePopustService.findSviPopustiZaSobu(sobaDTO.getSoba());
        if(sobaDTO.getPopust() < 0){
            return new ResponseEntity<>(new SobaNaPopustuDTO(), HttpStatus.FORBIDDEN);
        }
        String flag = "";
        if(sobaDTO.getDatumDo().isAfter(sobaDTO.getDatumOd())) {
            for (SobaNaPopustu s : sviPopustiZaSobu) {
                if (sobaDTO.getDatumOd().isAfter(s.getOdDatuma()) && sobaDTO.getDatumOd().isBefore(s.getDoDatuma())) {
                    flag = "Preklapanje zeljenog intervala sa vec postojecim intervalom za popust: " + s.getOdDatuma() + ":" + s.getDoDatuma();
                    break;
                }
                if (sobaDTO.getDatumDo().isAfter(s.getOdDatuma()) && sobaDTO.getDatumDo().isBefore(s.getDoDatuma())) {
                    flag = "Preklapanje zeljenog intervala sa vec postojecim intervalom za popust: " + s.getOdDatuma() + ":" + s.getDoDatuma();
                    break;
                }
                if (sobaDTO.getDatumOd().isBefore(s.getOdDatuma()) && sobaDTO.getDatumDo().isAfter(s.getOdDatuma())) {
                    flag = "Preklapanje zeljenog intervala sa vec postojecim intervalom za popust: " + s.getOdDatuma() + ":" + s.getDoDatuma();
                    break;
                }

            }
        }
        else{
            flag = "Datum do koga važi popust mora biti manji od datuma od koga važi popust!";
        }

        if(flag.equals("")) {
            Hotel h = hotelService.findOne(idHotela);
            Soba s = sobaService.findOne(sobaDTO.getSoba());
            Set<Usluga> usluge = new HashSet<>();
            for (Long i : sobaDTO.getUsluge()) {
                usluge.add(uslugaService.findOne(i));
            }
            SobaNaPopustu nova = new SobaNaPopustu(s, sobaDTO.getDatumOd(), sobaDTO.getDatumDo(), sobaDTO.getPopust(), h, usluge);
            sobePopustService.save(nova);
            System.out.println("Flag za sobe na popustu" + flag);
            return new ResponseEntity<>(sobaDTO, HttpStatus.OK);
        }
        else{
            System.out.println(flag);
            return new ResponseEntity<>(sobaDTO, HttpStatus.FORBIDDEN);
        }
    }

   // @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/getSobeNaPopustu/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<SobaNaPopustuResponseDTO>> getSobeNaPopustu(@RequestBody DatumDTO datumDTO,@PathVariable("id") Long id){

        List<SobaNaPopustu> sobe;
        if(datumDTO.getDatumDo() == null){
            sobe = sobePopustService.findSveZaDatum(id,datumDTO.getDatumOd());
        }
        else{
            sobe = sobePopustService.findSveZaDatume(id,datumDTO.getDatumOd(), datumDTO.getDatumDo());
        }

        System.out.println(datumDTO.getDatumOd());
        System.out.println(sobe.size());
        ArrayList<SobaNaPopustuResponseDTO> retVal = new ArrayList<>();

        for(SobaNaPopustu s : sobe){
            ArrayList<LocalDate> datumi = new ArrayList<>();
            long cenaSvihNocenjaZaSobu = 0;
            long i = 0;
            LocalDate noviDatum = null;
            do{
                noviDatum = s.getOdDatuma().plusDays(i);
                if(noviDatum.isEqual(s.getDoDatuma())){
                    break;
                }
                else{
                    cenaSvihNocenjaZaSobu+= cenaNocenjaService.getCenaNocenjaZaDatum(noviDatum,s.getSoba().getId()).getCena();
                }
                i++;
            }while(noviDatum.isBefore(s.getDoDatuma()));

            int cenaUsluga = 0;
            int ukupanPopust = 0;
            ArrayList<UslugaDTO> usluge = new ArrayList<>();
            for(Usluga us : s.getDodatneUsluge()){ //vidi da nije null
                usluge.add(new UslugaDTO(us));
                cenaUsluga+=us.getCena();
                if(ukupanPopust + us.getPopust()<=20){
                    ukupanPopust+=us.getPopust();
                }
                else{
                    ukupanPopust = 20;
                }
            }
            double cenaSobeSaPopustomUsluga = cenaSvihNocenjaZaSobu + cenaUsluga;
            double percentage = ukupanPopust * 0.01;
            cenaSobeSaPopustomUsluga = cenaSobeSaPopustomUsluga - cenaSobeSaPopustomUsluga*percentage;
            BigDecimal bd = new BigDecimal(cenaSobeSaPopustomUsluga);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            cenaSobeSaPopustomUsluga = bd.doubleValue();
            double novaCena = cenaSobeSaPopustomUsluga;
            double novaPercentage = s.getPopust() * 0.01;
            novaCena = novaCena - novaCena*novaPercentage;
            BigDecimal bdn = new BigDecimal(novaCena);
            bdn = bdn.setScale(2, RoundingMode.HALF_UP);
            novaCena = bdn.doubleValue();
            retVal.add(new SobaNaPopustuResponseDTO(new SobaDTO(s.getSoba()),id,usluge,s.getOdDatuma(),s.getDoDatuma(),s.getPopust(), cenaSobeSaPopustomUsluga, novaCena));
        }

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
   // @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/brzaRezervacija/{idGlavne}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<SobaNaPopustuResponseDTO> izvrsiBrzuRezervaciju(@RequestBody SobaNaPopustuResponseDTO sobaDTO, @PathVariable("idGlavne") Long id){
        long ukupnaCenaRezervacije =  0;
        long ukupanPopust = 0;
        Soba s = sobaService.findOne(sobaDTO.getSoba().getId());

            boolean zauzeta = false;

            List<ZauzetostSobe> zauzetost = zauzetostSobeService.findZauzetostZaSobuOdDatuma(s.getId(),sobaDTO.getDatumOd());
            if(zauzetost == null){
                System.out.println("Zauzetost je null!");
                zauzeta = false;
            }
            else{
                for(ZauzetostSobe z : zauzetost){

                    if(sobaDTO.getDatumDo().isBefore(z.getDoDatuma().plusDays(1)) && sobaDTO.getDatumDo().isAfter(z.getOdDatuma())){
                        zauzeta = true;
                        break;
                    }
                    if(sobaDTO.getDatumDo().isAfter(z.getDoDatuma()) && sobaDTO.getDatumOd().isBefore(z.getDoDatuma())){
                        zauzeta = true;
                        break;
                    }

                }

            }

        if(zauzeta){
            //ne moze
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        else{
            //moze dodavanje i sve
            Set<Usluga> usluge = new HashSet<>();

            ZauzetostSobe zSobe = new ZauzetostSobe(sobaDTO.getDatumOd(), sobaDTO.getDatumDo(),s);

            for(UslugaDTO usluga : sobaDTO.getUsluge()){
                //hmmm ti je ovo ovde
                Usluga us = uslugaService.findOne(usluga.getId());
                if(us!=null){
                    usluge.add(us);
                }

            }
            Set<ZauzetostSobe> zauzetosti = new HashSet<>();
            zauzetosti.add(zSobe);
            RezervacijaHotela rezervacija = new RezervacijaHotela(zauzetosti,usluge,sobaDTO.getNovaCena(), sobaDTO.getDatumOd(), sobaDTO.getDatumDo(),sobaDTO.getIdHotela(),1 );
//            RezervacijaLeta rl = letService.findOne(id);
//            rl.setRezervacijaHotela(rezervacija);
//            letService.save(rl);
//            rezervacijaHotelaService.save(rezervacija);

            return new ResponseEntity<>(sobaDTO, HttpStatus.OK);

        }


    }

   // @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/getPrihodeHotela/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrihodiDTO> getPrihodeHotela(@RequestBody DatumDTO datumDTO, @PathVariable("id") Long id){

        List<RezervacijaHotela> rezervacijeZaOdabraniPeriod = rezervacijaHotelaService.findAllRezervacijeZaHotelIDatum(id,datumDTO.getDatumOd(),datumDTO.getDatumDo());
        //TODO resi ako nema prihoda
        if(datumDTO.getDatumOd().isAfter(datumDTO.getDatumDo())){
            return new ResponseEntity<>(new PrihodiDTO(), HttpStatus.FORBIDDEN);
        }
        long cenaUsluga = 0;
        long ukupnaCena = 0;


        for(RezervacijaHotela rh : rezervacijeZaOdabraniPeriod){
            for(Usluga u : rh.getDodatne_usluge()){
                cenaUsluga+=u.getCena();
            }
            ukupnaCena+=rh.getUkupnaCenaRezervacije();
        }
        long cenaSoba = ukupnaCena - cenaUsluga;

        PrihodiDTO retVal = new PrihodiDTO(cenaSoba, cenaUsluga, ukupnaCena);

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
  //  @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getGrafikPosecenosti/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ArrayList<GrafikPosecenostiDTO>> getGrafikPosecenosti(@RequestBody GrafikRequestDTO grafikDTO, @PathVariable("id") Long id){

        if(grafikDTO.getDatumOd().isAfter(grafikDTO.getDatumDo())){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
        }
        GrafikPosecenostiDTO retVal = new GrafikPosecenostiDTO();
        List<RezervacijaHotela> sveRezervacije = rezervacijaHotelaService.findAllRezervacijeZaHotel(id,grafikDTO.getDatumOd(),grafikDTO.getDatumDo());
        Map<String, Integer> mapaBrojaGostiju = new HashMap<>();
        LocalDate reqOd = grafikDTO.getDatumOd();
        LocalDate reqDo = grafikDTO.getDatumDo();
        ArrayList<LocalDate> listaSvihDatuma = new ArrayList<>();
        Map<String, Integer> mesecMapa = new HashMap<>();
        Map<String, Integer> mapaSedmica = new HashMap<>();
        ArrayList<GrafikPosecenostiDTO> listaPosecenostiDnevna = new ArrayList<>();
        ArrayList<GrafikPosecenostiDTO> listaPosecenostiMesecna = new ArrayList<>();
        ArrayList<GrafikPosecenostiDTO> listaPosecenostiSedmicna = new ArrayList<>();


        int dayZeroBrojGostiju = 0;
        for(RezervacijaHotela rezervacija : sveRezervacije){
            if(rezervacija.getOdDatuma().isBefore(grafikDTO.getDatumOd()) || rezervacija.getOdDatuma().isEqual(grafikDTO.getDatumOd())){
                dayZeroBrojGostiju += rezervacija.getBrojGostiju();
            }
        }

        long i = 0;
        LocalDate datum = null;
        do{
            datum = reqOd.plusDays(i);
            listaSvihDatuma.add(datum);
            i++;
        }while(datum.isBefore(reqDo));

        //TODO vidi ogranicenja za datume, problem je ako nema rezervacija u zadatom intervalu itd
        if(grafikDTO.getTip().equals("Dnevno")){
            for( int k = 0; k < listaSvihDatuma.size(); k++){

                LocalDate danas = listaSvihDatuma.get(k);


                if(k==0){
                    String zaMapu = listaSvihDatuma.get(k).getDayOfMonth() + "-" + listaSvihDatuma.get(k).getMonthValue() + "-" + listaSvihDatuma.get(k).getYear();
                    mapaBrojaGostiju.put(zaMapu, dayZeroBrojGostiju);

                }
                else{
                    LocalDate juce = listaSvihDatuma.get(k-1);
                    String zaMapuDanas = danas.getDayOfMonth() + "-" + danas.getMonthValue() + "-" + danas.getYear();
                    String zaMapuJuce = juce.getDayOfMonth() + "-" + juce.getMonthValue() + "-" + juce.getYear();
                    for(RezervacijaHotela rez : sveRezervacije) {
                        if (rez.getOdDatuma().isEqual(danas)) {
                            int brojGostijuJuce = mapaBrojaGostiju.get(zaMapuJuce);
                            mapaBrojaGostiju.put(zaMapuDanas, brojGostijuJuce + rez.getBrojGostiju());
                        }
                        else if(rez.getDoDatuma().isEqual(danas)){
                            int brojGostijuJuce = mapaBrojaGostiju.get(zaMapuJuce);
                            mapaBrojaGostiju.put(zaMapuDanas, brojGostijuJuce - rez.getBrojGostiju());
                        }
                        else{
                            int brojGostijuJuce = mapaBrojaGostiju.get(zaMapuJuce);
                            mapaBrojaGostiju.put(zaMapuDanas, brojGostijuJuce);
                        }
                    }
                }
            }

            for(String key : mapaBrojaGostiju.keySet()){
                listaPosecenostiDnevna.add(new GrafikPosecenostiDTO(key, mapaBrojaGostiju.get(key)));
            }
            Collections.sort( listaPosecenostiDnevna, (o1, o2) -> {
                String[] parts1 = o1.getLabel().split("-");
                String[] parts2 = o2.getLabel().split("-");
                Integer sum1 = Integer.parseInt(parts1[0]) + Integer.parseInt(parts1[1]) * 10 + Integer.parseInt(parts1[2]) * 100;
                Integer sum2 = Integer.parseInt(parts2[0]) + Integer.parseInt(parts2[1]) * 10 + Integer.parseInt(parts2[2]) * 100;
                return sum1.compareTo(sum2);
            });

            return new ResponseEntity<>(listaPosecenostiDnevna, HttpStatus.OK);

        }
        else if(grafikDTO.getTip().equals("Mesecno")){
            //TODO vidi da li kupis dobro rezervacije iz baze za ovo
            int mesecOd = reqOd.getMonthValue();
            int mesecDo = reqDo.getMonthValue();
            int godinaOd = reqOd.getYear();
            int godinaDo = reqDo.getYear();
            int brojMeseciIzmedju = 0;
            if(godinaOd == godinaDo){
                brojMeseciIzmedju = mesecDo - mesecOd + 1;
            }else{
                int brojGodIzm = godinaDo - godinaOd;
                brojMeseciIzmedju = 12 - mesecOd + Math.abs(12 - (12 - mesecDo)) + 12 * (brojGodIzm-1) + 1;
            }

            for(int m = 0; m< brojMeseciIzmedju ; m++){
                if(mesecOd + m <= 12){
                    int zaPut = mesecOd + m;
                    mesecMapa.put(zaPut + "-" + godinaOd,0);
                }
                else
                {
                    int noviMesec = (mesecOd + m) % 12;
                    int novaGodina = godinaOd + ((mesecOd + m) / 12);
                    mesecMapa.put(noviMesec + "-" + novaGodina,0);
                }
            }
            for(RezervacijaHotela rez : sveRezervacije){
                LocalDate dolazak = rez.getOdDatuma();
                int mesec = dolazak.getMonthValue();
                int godina = dolazak.getYear();
                String zaMapu = mesec + "-" + godina;
                System.out.println("Za mapu tamo null sto baca: " + zaMapu);
                int stari = mesecMapa.get(zaMapu);
                mesecMapa.put(zaMapu, stari + rez.getBrojGostiju());
            }
            for(String key : mesecMapa.keySet()){
                listaPosecenostiMesecna.add(new GrafikPosecenostiDTO(key, mesecMapa.get(key)));
            }

            Collections.sort( listaPosecenostiMesecna, (o1, o2) -> {
                String[] parts1 = o1.getLabel().split("-");
                String[] parts2 = o2.getLabel().split("-");
                Integer sum1 = Integer.parseInt(parts1[0]) + Integer.parseInt(parts1[1]) * 100;
                Integer sum2 = Integer.parseInt(parts2[0]) + Integer.parseInt(parts2[1]) * 100;
                return sum1.compareTo(sum2);
            });

            return new ResponseEntity<>(listaPosecenostiMesecna, HttpStatus.OK);

        }
        else if(grafikDTO.getTip().equals("Sedmicno")){
            //TODO vidi ona ogranicenja da je selektovan ponedeljak itd, i za one ostale isto
            LocalDate datumZaSedmicu = reqOd.minusDays(7);

            do{
                datumZaSedmicu = datumZaSedmicu.plusDays(7);
                if(!datumZaSedmicu.isBefore(reqDo.plusDays(1))){
                    break;
                }
                else{
                    String zaMapu = datumZaSedmicu.getDayOfMonth() + "-" + datumZaSedmicu.getMonthValue() + "-" + datumZaSedmicu.getYear();
                    System.out.println("U mapi: " + zaMapu);
                    mapaSedmica.put(zaMapu, 0);
                }

            }while(datumZaSedmicu.isBefore(reqDo.plusDays(1)));

            for(RezervacijaHotela rez : sveRezervacije){
                LocalDate dolazak = rez.getOdDatuma();
                LocalDate dolazakPonedeljak = dolazak;
                if(dolazak.getDayOfWeek().getValue()!= 1){
                    dolazakPonedeljak = dolazak.minusDays(dolazak.getDayOfWeek().getValue() - 1);
                }
                String zaMapu = dolazakPonedeljak.getDayOfMonth() + "-" + dolazakPonedeljak.getMonthValue() + "-" + dolazakPonedeljak.getYear();
                System.out.println("Za mapu null pointer:"  + zaMapu);
                int stari = mapaSedmica.get(zaMapu);
                mapaSedmica.put(zaMapu, stari + rez.getBrojGostiju());
            }
            for(String key : mapaSedmica.keySet()){
                listaPosecenostiSedmicna.add(new GrafikPosecenostiDTO(key,mapaSedmica.get(key)));
            }
            Collections.sort( listaPosecenostiSedmicna, (o1, o2) -> {
                String[] parts1 = o1.getLabel().split("-");
                String[] parts2 = o2.getLabel().split("-");
                Integer sum1 = Integer.parseInt(parts1[0]) + Integer.parseInt(parts1[1]) * 20 + Integer.parseInt(parts1[2]) * 100;
                Integer sum2 = Integer.parseInt(parts2[0]) + Integer.parseInt(parts2[1]) * 20 + Integer.parseInt(parts2[2]) * 100;
                return sum1.compareTo(sum2);
            });


            return new ResponseEntity<>(listaPosecenostiSedmicna, HttpStatus.OK);
        }
        else{

            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }

    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/izmeniHotel/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<HotelDTO> izmeniSobu(@RequestBody HotelDTO hotelDTO, @PathVariable("id") Long id){

        hotelService.updateHotel(id,hotelDTO.getNaziv(),hotelDTO.getDrzava(),hotelDTO.getGrad(),hotelDTO.getAdresa(),hotelDTO.getPromoOpis());
        return new ResponseEntity<>(hotelDTO, HttpStatus.OK);

    }
    @RequestMapping(value = "/getSlobodneSobe/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ArrayList<SobaDTO>> getSlobodneSobe(@RequestBody DatumDTO datumDTO, @PathVariable("id") Long id){


        if(datumDTO.getDatumOd().isAfter(datumDTO.getDatumDo().minusDays(1))){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Hotel h = hotelService.findOne(id);

        if(h == null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Set<Soba> sobe = h.getSobe();
        ArrayList<SobaDTO> slobodneSobe = new ArrayList<>();
        for(Soba s: sobe){
            List<ZauzetostSobe> zauzetost = zauzetostSobeService.findZauzetostZaSobuOdDatuma(s.getId(),datumDTO.getDatumOd());
            if(zauzetost == null){
                System.out.println("Zauzetost je null!");
                slobodneSobe.add(new SobaDTO(s));
            }
            else{
                boolean zauzeta = false;
                for(ZauzetostSobe z : zauzetost){

                    if(datumDTO.getDatumDo().isBefore(z.getDoDatuma().plusDays(1)) && datumDTO.getDatumDo().isAfter(z.getOdDatuma())){
                        zauzeta = true;
                        break;
                    }
                    if(datumDTO.getDatumDo().isAfter(z.getDoDatuma()) && datumDTO.getDatumOd().isBefore(z.getDoDatuma())){
                        zauzeta = true;
                        break;
                    }

                }
                if(!zauzeta){
                    slobodneSobe.add(new SobaDTO(s));
                }
            }
        }

        return new ResponseEntity<>(slobodneSobe,HttpStatus.OK);
    }
}
