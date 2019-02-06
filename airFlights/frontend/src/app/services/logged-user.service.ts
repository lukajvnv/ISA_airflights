import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoggedUserService {

  private getLoggedUserURL = 'http://localhost:8836/auth/getLoggedUser';

  private updateUserUrl = 'http://localhost:8836/api/updateBasicInfo';

  constructor(private http: HttpClient) { }

  getLoggedUser(): Observable<any> {
    return this.http.get(this.getLoggedUserURL);
  }

  updateUser(user: User): Observable<any> {
    return this.http.put(this.updateUserUrl, user);
  }
}
