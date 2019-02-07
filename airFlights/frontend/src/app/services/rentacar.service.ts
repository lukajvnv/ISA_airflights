import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rentacar } from '../models/rentacar.model';

@Injectable({
  providedIn: 'root'
})
export class RentacarService {

  private getAllRentacarUrl = 'http://localhost:8836/rentacar/all';
  private getRentacarUrl = 'http://localhost:8836/rentacar/';
  private updateRentacarUrl = 'http://localhost:8836/rentacar/update';
  private getRentacarBranchesUrl = 'http://localhost:8836/rentacar/branches';

  constructor(private http: HttpClient) { 
  }

  getRentacars(): Observable<any> {
    return this.http.get(this.getAllRentacarUrl);
  }

  getRentacar(rentacarId: number): Observable<any> {
    return this.http.get(this.getRentacarUrl + rentacarId)
  }

  getRentacarBranches(rentacarId: number): Observable<any> {
    return this.http.get(this.getRentacarBranchesUrl + rentacarId);
  }

  updateRentacar(rentacar: Rentacar): Observable<any> {
    return this.http.put(this.updateRentacarUrl, rentacar);
  }
  
}
