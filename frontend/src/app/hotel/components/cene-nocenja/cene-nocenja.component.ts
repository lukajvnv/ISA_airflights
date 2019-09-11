import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-cene-nocenja',
  templateUrl: './cene-nocenja.component.html',
  styleUrls: ['./cene-nocenja.component.css']
})
export class CeneNocenjaComponent implements OnInit {


  cenaNocenjaForm = new FormGroup({
    odDatuma: new FormControl('',Validators.required),
    doDatuma: new FormControl('',Validators.required),
    cena: new FormControl('',Validators.required),
  });

  soba : any;
  private uloga : String;
  private submitted = false;
  constructor(private hotelService : HotelService, private route : ActivatedRoute) { }

  ngOnInit() {

   this.getSoba();
   }
  get f() { return this.cenaNocenjaForm.controls; }


  onSubmit(){

    this.submitted = true;

    if(this.cenaNocenjaForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      
    }
    else{
      this.dodajCenuNocenja();
    }
  }
  getSoba(){
    const id = +this.route.snapshot.paramMap.get("id");
    this.hotelService.getSoba(id).
    subscribe((response) => {
      this.soba = response;
    },error => console.log(error));
  }
  dodajCenuNocenja(){
    const id = +this.route.snapshot.paramMap.get('id');
    this.hotelService.dodajCenuNocenja(this.cenaNocenjaForm.value,id).
    subscribe((response) =>{
      console.log(response);
      alert("Uspesno ste dodali cenu nocenja za sobu!");
    },error => console.log(error));
  }
}
