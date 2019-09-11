import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dodaj-hotel',
  templateUrl: './dodaj-hotel.component.html',
  styleUrls: ['./dodaj-hotel.component.css']
})
export class DodajHotelComponent implements OnInit {


  noviHotelForm = new FormGroup({
    naziv: new FormControl('',Validators.required),
    drzava: new FormControl('',Validators.required),
    grad: new FormControl('',Validators.required),
    adresa: new FormControl('',Validators.required),
    promoOpis: new FormControl('')

  });

  private submitted = false;
  private updateHotel : boolean = false;
  private updateResponse : any;

  constructor(private hotelService : HotelService, private route : ActivatedRoute) { }

  ngOnInit() {
    this.forUpdate();
  }

  get f() { return this.noviHotelForm.controls; }


  onSubmit(){

    this.submitted = true;

    if(this.noviHotelForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      this.izmeniHotel();
    }
    else{
      this.registrujHotel();
    }
  }

  registrujHotel(){
    this.hotelService.registrujHotel(this.noviHotelForm.value)
    .subscribe((response) =>{
      console.log(response);
      alert("Uspesno ste registrovali novi hotel!");
    }, error => console.log(error));
  }
  izmeniHotel(){
    const id = +this.route.snapshot.paramMap.get('id');
    this.hotelService.izmeniHotel(this.noviHotelForm.value,id)
    .subscribe((response) =>{
      console.log(response);
      alert("Uspesno ste izmenili podatke o hotelu!");
    }, error => console.log(error));
  }
  forUpdate(){
    if(window.location.href.includes("izmeni")){
      this.updateHotel = true;
      const id = +this.route.snapshot.paramMap.get('id');
      this.hotelService.getHotel(id)
      .subscribe((response)=>{
        this.updateResponse = response;
        this.noviHotelForm.setValue({
          naziv: this.updateResponse.naziv,
          drzava: this.updateResponse.drzava ,
          grad: this.updateResponse.grad ,
          adresa: this.updateResponse.adresa ,
          promoOpis: this.updateResponse.promoOpis
        });
      }, error => console.log(error));
    }
    else{
      this.updateHotel = false;
      this.noviHotelForm.setValue({
        naziv: "",
        drzava: "",
        grad: "",
        adresa: "",
        promoOpis: ""
      });
    }
  }

}
