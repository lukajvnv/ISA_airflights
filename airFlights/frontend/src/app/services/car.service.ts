import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Car } from '../models/car.model';
import { Observable } from 'rxjs';
import { getCanActivateChild } from '@angular/router/src/utils/preactivation';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private newCarUrl = 'http://localhost:8836/rentacar/newCar/';
  private getCarsUrl = 'http://localhost:8836/car/getAllCars';
  private getCarReservationsUrl = 'http://localhost:8836/reservation/getCarReservations'
  
  rentacarId: string;

  constructor(private http: HttpClient) { }

  addNewCar(newCar: Car): Observable<any> {
    return this.http.post(this.newCarUrl + this.rentacarId, newCar);
  }

  getCars(): Observable<any> {
    return this.http.get(this.getCarsUrl);
  }

  getRentaCarId(rentacarId: string): void {
    this.rentacarId = rentacarId;
  }

  /*getAllCarReservations(): Observable<any> {
    return this.http.get(this.getCarReservationsUrl);
  }*/

}
