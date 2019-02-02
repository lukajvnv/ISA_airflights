import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Destination } from '../models/destination.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

  private newDestinationUrl = 'http://localhost:8080/airline/newDestination';

  constructor(private http: HttpClient) { }

  addNewDestination(newDestination: Destination): Observable<any> {
    return this.http.post(this.newDestinationUrl, newDestination);
  }
}
