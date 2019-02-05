import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  model: CarViewModel = {
    carName: '',
    carBrand: '',
    carModel: '',
    carYear: 1111,
    numberOfSeats: 0,  
    price: 0
  }

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  sendCar(): void {
    const url = 'http://localhost:8836/rentacar/addCar';
    this.http.post(url, this.model).subscribe(
      res => {
        alert('Successful');
      },
      err => {
        alert('Error has occured while adding new car');
      }
    );
  }
}

export interface CarViewModel {
  carName: string;
  carBrand: string;
  carModel: string;
  carYear: number;
  numberOfSeats: number;
  price: number;
}
