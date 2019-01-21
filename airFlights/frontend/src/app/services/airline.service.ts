import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  private getAllAirlineUrl = 'http://localhost:8080/airline/all';

  constructor(private http: HttpClient) { }

  getAirlines(): Observable<any> {
    return this.http.get(this.getAllAirlineUrl);
  }
}
