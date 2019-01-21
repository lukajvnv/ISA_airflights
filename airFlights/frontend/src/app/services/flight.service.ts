import { SearchFlightParams } from './../models/search-flight-params.model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private destinationsUrl = 'http://localhost:8080/flight/getAllDestinations';
  private searchFlightsUrlOneWay = 'http://localhost:8080/flight/search/oneWay';
  private searchFlightsUrlRoundTrip = 'http://localhost:8080/flight/search/roundTrip';
  private searchFlightsUrlMultiCity = 'http://localhost:8080/flight/search/multiCity';

  private getFlightBase = 'http://localhost:8080/flight/';

  constructor(private http: HttpClient) { }

  getDestinations(): Observable<any> {
    return this.http.get(this.destinationsUrl);
  }

  searchFlights(searchFlightParams: SearchFlightParams): Observable<any> {
    console.log(searchFlightParams);
    let urlPath: string;
    switch (searchFlightParams.flightType) {
      case 'ONE_WAY': urlPath = this.searchFlightsUrlOneWay; break;
      case 'ROUND_TRIP': urlPath = this.searchFlightsUrlRoundTrip; break;
      case 'MULTI_CITY': urlPath = this.searchFlightsUrlMultiCity; break;
      default: return;
    }
    // const params = new HttpParams().set('searchFlightParams', JSON.stringify(searchFlightParams));
    // this.http.get(urlPath, params);
    return this.http.post(urlPath, searchFlightParams);
  }

  getFlight(flightId: string): Observable<any> {
    return this.http.get(this.getFlightBase + flightId)/*.map(response => response.json()).catch()*/;
  }
}
