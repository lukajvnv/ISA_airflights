import { Flight } from './../models/flight.model';
import { SearchFlightParams } from './../models/search-flight-params.model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pricelist } from '../models/pricelist.model';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private destinationsUrl = 'http://localhost:8836/flight/getAllDestinations';

  private searchFlightsUrlOneWay = 'http://localhost:8836/flight/search/oneWay';
  private searchFlightsUrlRoundTrip = 'http://localhost:8836/flight/search/roundTrip';
  private searchFlightsUrlMultiCity = 'http://localhost:8836/flight/search/multiCity';

  private searchFlightsUrlOneWayComplex = 'http://localhost:8836/flight/search/oneWayComplex';
  private searchFlightsUrlRoundTripComplex = 'http://localhost:8836/flight/search/roundTrip';
  private searchFlightsUrlMultiCityComplex = 'http://localhost:8836/flight/search/multiCity';

  private getFlightBase = 'http://localhost:8836/flight/';

  private newFlightUrl = 'http://localhost:8836/flight/new';
  private updateFlightUrl = 'http://localhost:8836/flight/update';

  private getAllPricelistUrl = 'http://localhost:8836/flight/pricelist/all';
  private addNewPricelistUrl = 'http://localhost:8836/flight/pricelist/new';

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

  searchFlightsComplex(searchFlightParams: SearchFlightParams): Observable<any> {
    console.log(searchFlightParams);
    let urlPath: string;
    switch (searchFlightParams.flightType) {
      case 'ONE_WAY': urlPath = this.searchFlightsUrlOneWayComplex; break;
      case 'ROUND_TRIP': urlPath = this.searchFlightsUrlRoundTripComplex; break;
      case 'MULTI_CITY': urlPath = this.searchFlightsUrlMultiCityComplex; break;
      default: return;
    }
    return this.http.post(urlPath, searchFlightParams);
  }

  getFlight(flightId: string): Observable<any> {
    return this.http.get(this.getFlightBase + flightId)/*.map(response => response.json()).catch()*/;
  }

  addNewFlight(newFlight: Flight): Observable<any> {
    // const params = new HttpParams().set('airlineId', airlineId);
    /* const options = airlineId ?
   { params: new HttpParams().set('airlineId', airlineId) } : {}; */
    return this.http.post(this.newFlightUrl, newFlight);
  }

  updateFlight(flight: Flight): Observable<any> {
    return this.http.put(this.updateFlightUrl, flight);
  }

  getAllPricelist(): Observable<any> {
    return this.http.get(this.getAllPricelistUrl);
  }

  addNewPricelist(pricelist: Pricelist): Observable<any> {
    return this.http.post(this.addNewPricelistUrl, pricelist);
  }

}
