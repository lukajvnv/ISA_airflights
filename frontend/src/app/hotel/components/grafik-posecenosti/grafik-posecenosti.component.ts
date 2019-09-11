import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { HotelService } from '../../services/hotel.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { NgbDateStructAdapter } from '@ng-bootstrap/ng-bootstrap/datepicker/adapters/ngb-date-adapter';

@Component({
  selector: 'app-grafik-posecenosti',
  templateUrl: './grafik-posecenosti.component.html',
  styleUrls: ['./grafik-posecenosti.component.css']
})
export class GrafikPosecenostiComponent implements OnInit {

  constructor(private hotelService : HotelService, private route : ActivatedRoute) { }


  grafikPosecenostiForm = new FormGroup({
    datumOd: new FormControl('',Validators.required),
    datumDo: new FormControl('',Validators.required),
    tip: new FormControl('',Validators.required)

  });  

  ngOnInit() {
  }

  data : any;
  dates = [];
  brojGostiju = [];
  chart = [];
  private submitted = false;

  get f() { return this.grafikPosecenostiForm.controls; }


  onSubmit(){

    this.submitted = true;

    if(this.grafikPosecenostiForm.invalid){
      return;
    }
    if(window.location.href.includes("izmeni")){
      
    }
    else{
      this.getPodatkeZaGrafik();
    }
  }
  getPodatkeZaGrafik(){
    const id = +this.route.snapshot.paramMap.get("id");
    this.hotelService.getPodaciZaGrafik(this.grafikPosecenostiForm.value, id)
    .subscribe((response) => {
      
      this.data = response;
      this.dates = [];
      this.brojGostiju = [];
      for(let dto of this.data){
        this.dates.push(dto.label);
        this.brojGostiju.push(dto.brojGostiju);
      }
      this.chart = new Chart('canvas', {
        type: 'line',
        data: {
          labels: this.dates,
          datasets: [
            { 
              data: this.brojGostiju,
              borderColor: "#3cba9f",
              fill: false
            },
          ]
        },
        options: {
          legend: {
            display: false
          },
          scales: {
            xAxes: [{
              display: true
            }],
            yAxes: [{
              display: true
            }],
          }
        }
      });
    }, error => console.log(error));
  }
  
}
