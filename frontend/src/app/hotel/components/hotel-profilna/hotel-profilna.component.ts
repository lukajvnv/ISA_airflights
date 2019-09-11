import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-hotel-profilna',
  templateUrl: './hotel-profilna.component.html',
  styleUrls: ['./hotel-profilna.component.css']
})
export class HotelProfilnaComponent implements OnInit {

  id: number;
  hotel: any;
  prosecnaOcena: any;
  adresa : string[];
  grad: string[];
  drzava: string[];
  urlCeneNocenja : string = "http://localhost:4200/ceneNocenja/";
  urlRezervisiSobu : string = "http://localhost:4200/rezervacijaSoba/";
  urlRezervisiSobuBrza : string = "http://localhost:4200/sobeNaPopustu/";
  sobeZaPrikaz = [];
  slobodneSobe : any;
  submitted = false;

  slobodneSobeForm = new FormGroup({
    datumOd: new FormControl(''),
    datumDo: new FormControl('')
  });

  constructor(private hotelService : HotelService, private route : ActivatedRoute) { }

  ngOnInit() {
    this.gethotel();
  }

  get f() { return this.slobodneSobeForm.controls; }

  onSubmit(){

    this.submitted = true;


      this.pretraziSobe();

  }


  gethotel(){
    
    this.id = +this.route.snapshot.paramMap.get("id");

    this.hotelService.getHotelnk(this.id).subscribe((response) => {
      
      this.hotel = response;
      this.adresa = this.hotel.adresa.split(" ");
      this.grad = this.hotel.grad.split(" ");
      this.drzava = this.hotel.drzava.split(" ");
      this.urlRezervisiSobu += this.hotel.id;
      this.urlRezervisiSobuBrza+=this.hotel.id;
      
      for(let soba of this.hotel.sobe){
        this.sobeZaPrikaz.push(soba);
      }

      this.prosecnaOcena = this.hotelService.getProsecnaOcena(this.hotel.ocene);
    },error => {console.log("Hotel nije moguce ucitati!");});
  }
  
  pretraziSobe(){
    const id = +this.route.snapshot.paramMap.get("id");
    if(this.slobodneSobeForm.controls['datumOd'] === undefined || this.slobodneSobeForm.controls['datumDo'] === undefined){
      return;
    }
    let odD = this.slobodneSobeForm.controls['datumOd'].value;
    let doD = this.slobodneSobeForm.controls['datumDo'].value;
    if(odD === '' || odD === null || doD === '' || doD === null){
      return;
    }
    this.sobeZaPrikaz = [];
    this.hotelService.getSlobodneSobe(this.slobodneSobeForm.value,id)
    .subscribe((response) =>{
      this.slobodneSobe = response;
      for(let soba of this.slobodneSobe){
        this.sobeZaPrikaz.push(soba);
      }
    }, error => console.log(error));
  }

}
