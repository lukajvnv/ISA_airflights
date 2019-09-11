import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-dodaj-sobu',
  templateUrl: './dodaj-sobu.component.html',
  styleUrls: ['./dodaj-sobu.component.css']
})
export class DodajSobuComponent implements OnInit {

  novaSobaForm = new FormGroup({
    brojSobe: new FormControl('',Validators.required),
    opis: new FormControl(''),
    brojKreveta: new FormControl('',Validators.required),
    sprat: new FormControl('',Validators.required)

  });
  private zaUpdate : boolean = false;
  private updateResponse : any;
  private submitted = false;

  constructor(private hotelService : HotelService, private route : ActivatedRoute) { }

  ngOnInit() {
    this.forUpdate();
  }

  get f() { return this.novaSobaForm.controls; }


  onSubmit(){

    this.submitted = true;

    if(this.novaSobaForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      this.izmeniSobu();
    }
    else{
      this.dodajSobu();
    }
  }

  dodajSobu(){
    
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(this.novaSobaForm.value);
    this.hotelService.dodajSobu(this.novaSobaForm.value, id)
    .subscribe((response) => {
      console.log(response);
      alert("Uspesno ste dodali sobu!");
    },error => console.log(error));
  }
  izmeniSobu(){
    const id = +this.route.snapshot.paramMap.get('id');
    this.hotelService.izmeniSobu(this.novaSobaForm.value,id).
    subscribe((response) =>{
      console.log(response);
    }, error => (console.log(error)));
  }
  forUpdate(){
    if(window.location.href.includes("izmeni")){
      this.zaUpdate = true;
      const id = +this.route.snapshot.paramMap.get('id');
      this.hotelService.getSoba(id).
      subscribe((response) => {
        this.updateResponse = response;
        this.novaSobaForm.setValue({
          brojSobe: this.updateResponse.brojSobe ,
          opis: this.updateResponse.opis ,
          brojKreveta:this.updateResponse.brojKreveta ,
          sprat: this.updateResponse.sprat
        });
      }, error => console.log(error));
    } else{
      this.zaUpdate = false;
      this.novaSobaForm.setValue({
        brojSobe: "" ,
        opis: "" ,
        brojKreveta:"" ,
        sprat: ""
      });
    }
  }

}
