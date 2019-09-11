import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {

  sobaNaPopustuForm = new FormGroup({
    soba: new FormControl('',Validators.required),
    usluge: new FormControl(''),
    datumOd: new FormControl('',Validators.required),
    datumDo: new FormControl('',Validators.required),
    popust: new FormControl('',Validators.required)

  });
  prikazPrihodaForm = new FormGroup({
    datumOd: new FormControl('',Validators.required),
    datumDo: new FormControl('',Validators.required)
  });

  chartInfo = []
  prihodi : any;
  hotel : any;
  prosecnaOcena : string;
  id : number = 0;
  soba : any;
  urlCeneNocenja : string = "http://localhost:4200/ceneNocenja/";
  urlGrafikPosecenosti : string = "http://localhost:4200/grafikPosecenosti/";
  urlUsluga : string;
  urlSoba : string;
  urlSobaIzmeni : string = "http://localhost:4200/izmeniSobu/";
  urlRezervisiSobu : string = "http://localhost:4200/rezervacijaSoba/";
  urlHotelIzmeni : string = "http://localhost:4200/izmeniHotel/"
  urlUsluguIzmeni : string = "http://localhost:4200/izmeniUslugu/"
  urlHotelAdmin : string = "http://localhost:4200/adminHotelProfile/";
  adresa : string[];
  grad: string[];
  drzava: string[];
  private uloga: string;
  private submitted = false;
  private submittedP = false;
  constructor(private hotelService : HotelService, private route : ActivatedRoute,private router : Router) { }

  ngOnInit() {
 
    this.gethotel();
  }


  get p() { return this.prikazPrihodaForm.controls; }


  onSubmitPrihodi(){

    this.submittedP = true;

    if(this.prikazPrihodaForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      
    }
    else{
      this.getPrihodi();
    }
  }

  get f() { return this.sobaNaPopustuForm.controls; }


  onSubmitPopust(){

    this.submitted = true;

    if(this.sobaNaPopustuForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      
    }
    else{
      this.dodajSobuNaPopustuClick();
    }
  }

  gethotel(){
    
    this.id = +this.route.snapshot.paramMap.get("id");
    this.urlUsluga = "http://localhost:4200/dodajUslugu/" + this.id;
    this.urlSoba = "http://localhost:4200/dodajSobu/" + this.id;
    this.urlGrafikPosecenosti+=this.id;
    this.urlHotelIzmeni += this.id;
    this.hotelService.getHotel(this.id).subscribe((response) => {
      
      this.hotel = response;
      this.adresa = this.hotel.adresa.split(" ");
      this.grad = this.hotel.grad.split(" ");
      this.drzava = this.hotel.drzava.split(" ");
      this.urlRezervisiSobu += this.hotel.id;

      this.prosecnaOcena = this.hotelService.getProsecnaOcena(this.hotel.ocene);
    },error => {console.log("Hotel nije moguce ucitati!"); this.router.navigate(["/login"])});
  }
  onIzbrisiSobuClick(id){
    this.hotelService.izbrisiSobu(id).subscribe((response) =>{console.log(response); this.gethotel();},error => console.log(error));
    
    console.log("Brisem sobu: " + id);
  }
  onIzbrisiUsluguClick(id){
    this.hotelService.izbrisiUslugu(id).subscribe((response) =>{console.log(response); this.gethotel();},error => console.log(error));
    
    console.log("Brisem uslugu: " + id);
  }
  onPrikaziProsecnuOcenuSobeClick(id){
    this.hotelService.getSoba(id).
    subscribe((response) => {
      this.soba = response;
      let prosecnaOcenaSobe = this.hotelService.getProsecnaOcena(this.soba.ocene);
      window.alert("Prosecna ocena za sobu broj " + this.soba.brojSobe+ " je: " + prosecnaOcenaSobe);
    });
  }
  dodajSobuNaPopustuClick(){
    const id = +this.route.snapshot.paramMap.get("id");
    this.hotelService.dodajSobuNaPopustu(this.sobaNaPopustuForm.value, id)
    .subscribe((response)=>{
      console.log(response);
      alert("Uspesno ste dodali sobu na popustu!");
    }, error => console.log(error));
  }
  getPrihodi(){
    const id = +this.route.snapshot.paramMap.get("id");
    this.hotelService.getPrihodi(this.prikazPrihodaForm.value, id)
    .subscribe((response) => {
      this.prihodi = response;
    }, error => console.log(error));
  }
}
