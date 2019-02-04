import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoggedUserService {

  private getLoggedUserURL = 'http://localhost:8836/auth/getLoggedUser';

  constructor(private http: HttpClient) { }

  getLoggedUser(): Observable<any> {
    return this.http.get(this.getLoggedUserURL);
  }
}
