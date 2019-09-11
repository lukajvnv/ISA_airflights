import { AirlineAnalyticsQuery } from './../models/airline-analytics-query.model';
import { FlightTicket } from './../models/flight-ticket';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Airline } from '../models/airline.model';
import { FlightSeat } from '../models/seat.model';
import { Reservation } from '../models/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  private getAllAirlineUrl = 'http://localhost:8836/airline/all';
  private getAirlineBase = 'http://localhost:8836/airline/';
  private updateAirlineUrlBase = 'http://localhost:8836/airline/update';

  private getAirlineFlightsUrlBase = 'http://localhost:8836/airline/flights/';

  private removeSeatUrl = 'http://localhost:8836/book/removeSeat';
  private addNewSeatUrl = 'http://localhost:8836/book/newSeat';
  private addQuickTicketUrl = 'http://localhost:8836/book/quickTicket';

  private getQuickTicketUrlBase = 'http://localhost:8836/airline/tickets/';

  private bookQuickTicketUrl = 'http://localhost:8836/book/buy/quickTicket';

  private getAirlineRatingUrlBase = 'http://localhost:8836/airline/getRating/';
  private getFlightRatingUrlBase = 'http://localhost:8836/airline/getFlightRating/';

  private getAirlineProitUrlBase = 'http://localhost:8836/airline/getProfit/';
  private getAirlineSellingTicketUrlBase = 'http://localhost:8836/airline/getReport/';

  constructor(private http: HttpClient) { }

  getAirlines(): Observable<any> {
    return this.http.get(this.getAllAirlineUrl);
  }

  getAirline(airlineId: string): Observable<any> {
    return this.http.get(this.getAirlineBase + airlineId)/*.map(response => response.json()).catch()*/;
  }

  getAirlineFlights(airlineId: string): Observable<any> {
    return this.http.get(this.getAirlineFlightsUrlBase + airlineId);
  }

  updateAirline(airline: Airline): Observable<any> {
    return this.http.put(this.updateAirlineUrlBase, airline);
  }

  removeSeat(seat: FlightSeat): Observable<any> {
    return this.http.post(this.removeSeatUrl, seat);
  }

  addNewSeat(seat: FlightSeat): Observable<any> {
    return this.http.post(this.addNewSeatUrl, seat);
  }

  addQuickTicket(ticket: FlightTicket): Observable<any> {
    return this.http.post(this.addQuickTicketUrl, ticket);
  }

  getQuickTickets(airlineId: string): Observable<any> {
    return this.http.get(this.getQuickTicketUrlBase + airlineId);
  }

  bookQuickTicket(reservation: Reservation): Observable<any> {
    return this.http.post(this.bookQuickTicketUrl, reservation);
  }

  getAirlineRating(airlineId: string): Observable<any> {
    return this.http.get(this.getAirlineRatingUrlBase + airlineId, {responseType: 'text'});
  }

  getFliightRating(flightId: string): Observable<any> {
    return this.http.get(this.getFlightRatingUrlBase + flightId, {responseType: 'text'});
  }

  getAirlineProfit(airlineId: string, query: AirlineAnalyticsQuery): Observable<any> {
    return this.http.post(this.getAirlineProitUrlBase + airlineId, query, {responseType: 'text'});
  }

  getAirlineReport(airlineId: string, query: AirlineAnalyticsQuery): Observable<any> {
    return this.http.post(this.getAirlineSellingTicketUrlBase + airlineId, query);
  }

}
