import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../models/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private getAllSeatsByFlightBase = 'http://localhost:8836/book/seats/flight/';
  private makeReservationUrl = 'http://localhost:8836/book/newReservation';



  constructor(private http: HttpClient) { }

  getAllSeats(flightId: string): Observable<any> {
    return this.http.get(this.getAllSeatsByFlightBase + flightId);
  }

  makeReservation(reservation: Reservation): Observable<any> {
    return this.http.post(this.makeReservationUrl, reservation);
  }
}
