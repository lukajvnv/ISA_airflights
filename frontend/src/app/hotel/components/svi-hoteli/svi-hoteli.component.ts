import { Component, OnInit, Input } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-svi-hoteli',
  templateUrl: './svi-hoteli.component.html',
  styleUrls: ['./svi-hoteli.component.css']
})
export class SviHoteliComponent implements OnInit {


  searchHotelForm = new FormGroup({
    naziv: new FormControl('',Validators.required),
    adresa: new FormControl('',Validators.required),
    grad: new FormControl('',Validators.required),
    drzava: new FormControl('',Validators.required)

  });
  
  hoteli: any;
  urlHoteluredjuj : string = "http://localhost:4200/hotelnk/";
  urlHotel: string = "http://localhost:4200/hotel/";
  filtriraniHoteli = [];
  uloga : String = "";

  constructor(private hotelService : HotelService) {}

  ngOnInit() {
    this.getHoteli();
  }

  pretraziHotele(){
    this.filtriraniHoteli = [];
    for(let hotel of this.hoteli){
      if(hotel.naziv.toLowerCase().includes(this.searchHotelForm.controls['naziv'].value.toLowerCase()) &&
         hotel.adresa.toLowerCase().includes(this.searchHotelForm.controls['adresa'].value.toLowerCase()) &&
         hotel.grad.toLowerCase().includes(this.searchHotelForm.controls['grad'].value.toLowerCase()) &&
         hotel.drzava.toLowerCase().includes(this.searchHotelForm.controls['drzava'].value.toLowerCase())){
         
          this.filtriraniHoteli.push(hotel);
      }
      else{
        
        console.log(this.searchHotelForm.controls['naziv'].value.toLowerCase()+ "=" + hotel.naziv.toLowerCase());
      }


    }
    
  }
  getHoteli(){
    this.hotelService.getHoteli().
    subscribe((response) => {
      this.hoteli = response;
      
      for (let hotel of this.hoteli){
        this.filtriraniHoteli.push(hotel);
      }
    }, error => console.log(error));
  }

}
