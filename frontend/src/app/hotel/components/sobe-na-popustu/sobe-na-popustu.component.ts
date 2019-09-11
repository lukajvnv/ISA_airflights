import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-sobe-na-popustu',
  templateUrl: './sobe-na-popustu.component.html',
  styleUrls: ['./sobe-na-popustu.component.css']
})
export class SobeNaPopustuComponent implements OnInit {

  private retVal : any;
  private datumValue : String[];
  private datumValueDo : String[];
  private idGlavne : number;
  constructor(private hotelService : HotelService,private route : ActivatedRoute) { }

  rezervacijaForm = new FormGroup({
    datumOd: new FormControl('',Validators.required),
    datumDo: new FormControl('',Validators.required)
  });

  ngOnInit() {
  
    
    this.getSobeNaPopustu();
  }

  getSobeNaPopustu(){
    const id = +this.route.snapshot.paramMap.get("id");
    this.hotelService.getSobeNaPopustu(id, this.rezervacijaForm.value)
    .subscribe((response) =>{
      console.log(response);
      this.retVal = response;
    }, error => console.log(error));
  }
  onClickBrzaRezervacija(idSobe){
    if(this.rezervacijaForm.controls['datumDo'].value === ""){
      alert("Morate izabrati datum do kog zelite da ostanete!");
      return;
    }
    for(let soba of this.retVal){
      if(soba.soba.id == idSobe){
        //datum od - get info
        let temp = soba;
        let formDatum = new Date(this.rezervacijaForm.controls['datumDo'].value);
        let sobaDate = new Date(temp.datumDo);
        temp.datumDo = this.rezervacijaForm.controls['datumDo'].value;
        temp.datumOd = this.rezervacijaForm.controls['datumOd'].value;

        if(formDatum > sobaDate){
          alert("Soba nije na popustu do tog perioda!");
          return;
        }
        // if(temp.soba.brojKreveta < info.brojSedista){
        //   alert('Broj kreveta u rezervisanoj sobi ne sme biti manji od broja putnika!');
        //   return;
        // }
        this.hotelService.brzaRezervacijaSobe(temp, this.idGlavne)
        .subscribe((response) =>{
            console.log(response);
        }, error => {console.log(error); alert('Ova soba je zauzeta u zeljenom periodu!');});
        break;
      }
    }
  }
}
