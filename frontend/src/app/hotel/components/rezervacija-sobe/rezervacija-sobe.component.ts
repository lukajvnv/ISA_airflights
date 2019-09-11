import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
  selector: 'app-rezervacija-sobe',
  templateUrl: './rezervacija-sobe.component.html',
  styleUrls: ['./rezervacija-sobe.component.css']
})
export class RezervacijaSobeComponent implements OnInit {


  rezervisiSobeForm = new FormGroup({
    datumDolaska: new FormControl('',Validators.required),
    brojGostiju: new FormControl('',Validators.required),
    brojNocenja: new FormControl('',Validators.required),
    cenaPoNocenjuOd: new FormControl('0'),
    cenaPoNocenjuDo: new FormControl('')

  });
  private listaSoba : any;
  private showSobe : boolean = false;
  private showForm : boolean = true;
  private showUsluge : boolean = false;
  private showSazetak : boolean = false;
  private sobeZaRezervaciju : any;
  private podaciSaForme : any;
  private listaUsluga: any;
  private dodatneUsluge : any;
  private rezervacija : any = {};
  private ukupnaCenaSvihSoba : any = 0;
  private ukupnaCenaSvihUsluga : any = 0;
  private ukupanPopustSvihUsluga : any = 0;
  private ukupnaSve : any = 0;
  private ukupnaCenaSaPopustom : any = 0;
  private submitted = false;
  constructor(private hotelService : HotelService, private route : ActivatedRoute, private router : Router) { }

  ngOnInit() {
    this.showForm = true;
    this.showSobe = false;
    this.showUsluge = false;
    this.showSazetak = false;
    this.ukupnaCenaSvihSoba = 0;
    this.ukupanPopustSvihUsluga = 0;
    this.ukupnaCenaSvihUsluga = 0;
   
  }

  get f() { return this.rezervisiSobeForm.controls; }


  onSubmit(){

    this.submitted = true;

    if(this.rezervisiSobeForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      
    }
    else{
      this.getSobeZaRezervaciju();
    }
  }

  getSobeZaRezervaciju(){
    const id = +this.route.snapshot.paramMap.get("id");
    this.hotelService.getSobeZaRezervaciju(this.rezervisiSobeForm.value,id)
    .subscribe((response) =>{
      this.listaSoba = response;
      this.showForm = false;
      this.showSobe = true;
      this.showUsluge = false;
      this.showSazetak = false;
      this.podaciSaForme = this.rezervisiSobeForm.value;
    }, error => console.log(error));
  }
  onPrikaziProsecnuOcenuSobeClick(id){
    this.hotelService.getSoba(id).
    subscribe((response) => {
      let soba : any = response;
      let prosecnaOcenaSobe = this.hotelService.getProsecnaOcena(soba.ocene);
      window.alert("Prosecna ocena za sobu broj " + soba.brojSobe+ " je: " + prosecnaOcenaSobe);
    });
  }
  onOdabirSobaClick(){
    var items = <HTMLInputElement[]> <any> document.getElementsByName("sobe");
    var selected : string[] = [];
    for(var i=0; i<items.length; i++){
			if(items[i].checked==true)
				selected.push(items[i].value);
    }
    if(selected.length == 0){
      alert("Morate izabrati barem jednu sobu!");
      return;
    }
    this.sobeZaRezervaciju = selected;
    this.rezervacija.sobe = [];
    for( var i = 0; i<selected.length;i++){
      for(var j = 0; j<this.listaSoba.length;j++){
        if(parseInt(selected[i])==this.listaSoba[j].soba.id){
          console.log("USAO U IF!");
          this.ukupnaCenaSvihSoba+=this.listaSoba[j].ukupnaCena;
          this.rezervacija.sobe.push(this.listaSoba[j]);
        }
      }
    }
    const id = +this.route.snapshot.paramMap.get("id");
    this.hotelService.getUslugeHotela(id)
    .subscribe((response)=>{
      this.listaUsluga = response;
      this.showForm = false;
      this.showSobe = false;
      this.showUsluge = true;
      this.showSazetak = false;
    }, error => console.log(error));
  }
  onIzvrsiRezervacijuClick(){
    var items = <HTMLInputElement[]> <any> document.getElementsByName("usluge");
    var selected : string[] = [];
    for(var i=0; i<items.length; i++){
			if(items[i].checked==true){
        selected.push(items[i].value);
      }
        
    }

    this.dodatneUsluge = selected;
    this.rezervacija.usluge = [];
    for( var i = 0; i<selected.length;i++){
      for(var j = 0; j<this.listaUsluga.length;j++){
        if(parseInt(selected[i])==this.listaUsluga[j].id){
          this.rezervacija.usluge.push(this.listaUsluga[j]);
          this.ukupnaCenaSvihUsluga+=this.listaUsluga[j].cena;
          this.ukupanPopustSvihUsluga+=this.listaUsluga[j].popust;
        }
      }
    }
    this.ukupnaSve = this.ukupnaCenaSvihSoba + this.ukupnaCenaSvihUsluga;

    let percentage = this.ukupanPopustSvihUsluga * 0.01;
    let cena = this.ukupnaSve - this.ukupnaSve * percentage;
    this.ukupnaCenaSaPopustom = parseFloat((Math.round(cena * 100) / 100).toString()).toFixed(2);
    this.showUsluge = false;
    this.showSazetak = true;

  }

  onPotvrdiRezervacijuClick(){
 
    const id = +this.route.snapshot.paramMap.get("id");
    this.rezervacija.podaci = this.podaciSaForme;
    this.hotelService.rezervisiSobe(this.rezervacija,id)
    .subscribe((response) => {
      this.showForm = false;
      this.showSobe = false;
      this.showUsluge = false;
      this.showSazetak = true;
      localStorage.removeItem("info");
      alert("Uspesno ste izvrsili rezervaciju!");
      //redirekt na home page za registrovanog
      console.log(response);
    }, error => {console.log(error); alert("Doslo je do greske prilikom rezervacije!");});
  }

  onPotvrdiRezervacijuSaAutomClick(){

    const id = +this.route.snapshot.paramMap.get("id");
    this.rezervacija.podaci = this.podaciSaForme;
    this.hotelService.rezervisiSobe(this.rezervacija,id)
    .subscribe((response) => {
      this.showForm = false;
      this.showSobe = false;
      this.showUsluge = false;
      this.showSazetak = true;
      console.log(response);
      alert("Sada cete biti preusmereni na rezervaciju vozila!");
      this.router.navigate(['/searchRentacar']);
    }, error => {console.log(error); alert("Doslo je do greske prilikom rezervacije!");});
  }

  onBackToFormClick(){
    this.showForm = true;
    this.showSobe = false;
    this.listaSoba = {};
    this.podaciSaForme = {};

  }
  onBackToSobeClick(){

    this.showUsluge = false;
    this.showSobe = true;
    this.sobeZaRezervaciju = [];
    this.rezervacija.sobe = [];
    this.ukupnaCenaSvihSoba = 0;
    this.listaUsluga = {};
  }
  onBackToUslugeClick(){
    this.showUsluge = true;
    this.showSazetak = false;
    this.rezervacija.usluge = [];
    this.dodatneUsluge = [];
    this.ukupnaCenaSvihUsluga = 0;
    this.ukupanPopustSvihUsluga = 0;
    
  }

}
