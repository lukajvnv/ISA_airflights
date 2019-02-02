import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Airline } from '../models/airline.model';

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  private getAllAirlineUrl = 'http://localhost:8080/airline/all';
  private getAirlineBase = 'http://localhost:8080/airline/';
  private updateAirlineUrlBase = 'http://localhost:8080/airline/update';

  private getAirlineFlightsUrlBase = 'http://localhost:8080/airline/flights/';


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

}
