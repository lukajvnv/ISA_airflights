import { Injectable } from '@angular/core';
import { Rentabranch } from '../models/rentabranch.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RentabranchService {

  private newRentaBranchUrl = 'http://localhost:8836/rentacar/newBranch/';
  private getBranchesUrl = 'http://localhost:8836/rentabranch/getAllBranches';

  rentacarId: string;

  constructor(private http: HttpClient) { }

  addNewRentaBranch(newBranch: Rentabranch): Observable<any> {
    return this.http.post(this.newRentaBranchUrl + this.rentacarId, newBranch);
  }

  getBranches(): Observable<any> {
    return this.http.get(this.getBranchesUrl);
  }

  getRentacarId(rentacarId: string): void {
    this.rentacarId = rentacarId;
  }
}
