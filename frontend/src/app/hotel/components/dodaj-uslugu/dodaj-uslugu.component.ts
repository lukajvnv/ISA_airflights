import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HotelService } from '../../services/hotel.service';

@Component({
  selector: 'app-dodaj-uslugu',
  templateUrl: './dodaj-uslugu.component.html',
  styleUrls: ['./dodaj-uslugu.component.css']
})
export class DodajUsluguComponent implements OnInit {

  novaUslugaForm = new FormGroup({
    naziv: new FormControl('',Validators.required),
    opis: new FormControl(''),
    cena: new FormControl('',Validators.required),
    popust: new FormControl('',Validators.required)

  });

  private submitted = false;
  private zaUpdate = false;
  private updateResponse : any;
  constructor(private hotelService : HotelService, private route : ActivatedRoute) { }


  ngOnInit() {
    this.forUpdate();
  }

  get f() { return this.novaUslugaForm.controls; }


  onSubmit(){

    this.submitted = true;

    if(this.novaUslugaForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      this.izmeniUslugu();
    }
    else{
      this.dodajUslugu();
    }
  }
  dodajUslugu(){
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(this.novaUslugaForm.value);
    this.hotelService.dodajUslugu(this.novaUslugaForm.value, id)
    .subscribe((response) => {
      console.log(response);
    },error => console.log(error));
  }

  izmeniUslugu(){
    const id = +this.route.snapshot.paramMap.get('id');
    this.hotelService.izmeniUslugu(this.novaUslugaForm.value,id).
    subscribe((response) =>{
      console.log(response);
    }, error => (console.log(error)));
  }
  forUpdate(){
    if(window.location.href.includes("izmeni")){
      this.zaUpdate = true;
      const id = +this.route.snapshot.paramMap.get('id');
      this.hotelService.getUsluga(id).
      subscribe((response) => {
        this.updateResponse = response;
        this.novaUslugaForm.setValue({
          naziv: this.updateResponse.naziv ,
          opis: this.updateResponse.opis ,
          cena: this.updateResponse.cena ,
          popust: this.updateResponse.popust
        });
      }, error => console.log(error));
    } else{
      this.zaUpdate = false;
      this.novaUslugaForm.setValue({
        brojSobe: "" ,
        opis: "" ,
        brojKreveta:"" ,
        sprat: ""
      });
    }
  }

}
