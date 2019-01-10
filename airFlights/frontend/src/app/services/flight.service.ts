import { SearchFlightParams } from './../models/search-flight-params.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private destinationsUrl = 'http://localhost:8080/flight/getAllDestinations';
  private searchFlightsUrl = 'http://localhost:8080/flight/search';


  constructor(private http: HttpClient) { }

  getDestinations(): Observable<any> {
    return this.http.get(this.destinationsUrl);
  }

  searchFlights(searchFlightParams: SearchFlightParams): Observable<any> {
    console.log(searchFlightParams);
    // const h = new HttpHeaders();
    // h.append('Content-Type', 'application/json');
    // let options = new RequestOptions({ headers: headers });
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.post(this.searchFlightsUrl, searchFlightParams);
  }
}
