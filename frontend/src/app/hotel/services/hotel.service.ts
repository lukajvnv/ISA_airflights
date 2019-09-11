import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private url = "http://localhost:8836/hoteli/";

  private hotelResponse : any;
  constructor(private http : HttpClient) { }

  getHotel(id : number){
    return this.http.get(this.url + "getHotel/" + id);  
  }
  getHoteli(){
    return this.http.get(this.url + "getHoteli");
  }
  dodajUslugu(usluga, id){
    return this.http.post(this.url + "dodajUslugu/" + id,usluga);
  }
  dodajSobu(soba, id){
    return this.http.post(this.url + "dodajSobu/" + id,soba);
  }
  izbrisiSobu(id){
    return this.http.delete(this.url + "izbrisiSobu/" + id);
  }
  izmeniSobu(soba, id){
    return this.http.put(this.url + "izmeniSobu/" + id, soba);
  }
  getSoba(id){
    return this.http.get(this.url + "getSoba/" + id);
  }
  dodajCenuNocenja(cenaNocenja, id){
    return this.http.post(this.url + "dodajCenuNocenja/" + id, cenaNocenja);
  }
  getProsecnaOcena(ocene){
    let sum = 0;
    let count = 0;
    for(let ocena of ocene){
      sum = sum + ocena.ocena;
      count++;
    }
    return parseFloat((Math.round(sum/count * 100) / 100).toString()).toFixed(2);
  }
  getSobeZaRezervaciju(rezervacija,id){
    return this.http.post(this.url + "getSobeZaRezervaciju/" + id,rezervacija);
  }
  getUslugeHotela(id){
    return this.http.get(this.url + "getUslugeHotela/" + id);
  }
  rezervisiSobe(rezervacija, id){
    return this.http.post(this.url + "izvrsiRezervaciju/" + id + "/" + id, rezervacija);
  }
  registrujHotel(noviHotel){
    return this.http.post(this.url + "registrujHotel", noviHotel);
  }
  dodajSobuNaPopustu(soba, id){
    return this.http.post(this.url + "dodajSobuNaPopustu/" + id, soba)
  }
  getSobeNaPopustu(idHotela, data){
    return this.http.post(this.url + "getSobeNaPopustu/" + idHotela, data);
  }
  brzaRezervacijaSobe(soba, idGlavne){
    return this.http.post(this.url + "brzaRezervacija/" + idGlavne, soba);
  }
  getPrihodi(datumi, id){
    return this.http.post(this.url + "getPrihodeHotela/" + id, datumi);
  }
  getPodaciZaGrafik(data, id){
    return this.http.post(this.url + "getGrafikPosecenosti/" + id, data);
  }
  izmeniHotel(data, id){
    return this.http.put(this.url + "izmeniHotel/" + id, data);
  }
  getKorisnik(){
    return JSON.parse(localStorage.getItem('ulogovaniKorisnik'));
  }
  getHotelnk(id){
    return this.http.get(this.url + "getHotelnk/" + id);
  }
  getSlobodneSobe(data,id){
    return this.http.post(this.url + "getSlobodneSobe/" + id, data);
  }
  getUsluga(id){
    return this.http.get(this.url + "getUsluga/" + id);
  }
  izmeniUslugu(data,id){
    return this.http.put(this.url + "izmeniUslugu/" + id, data);
  }
  izbrisiUslugu(id){
    return this.http.delete(this.url + "izbrisiUslugu/" + id);
  } 
}
