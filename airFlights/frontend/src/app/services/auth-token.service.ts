import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthTokenService {

  private TOKEN_KEY = 'jwt_token';

  constructor(private http: HttpClient) { }

  getJwtToken() {
    return localStorage.getItem(this.TOKEN_KEY);
  };

  setJwtToken(token) {
    localStorage.setItem(this.TOKEN_KEY, token);
  };

  removeJwtToken() {
    localStorage.removeItem(this.TOKEN_KEY);
  };

  createAuthorizationTokenHeader() {
    let token = this.getJwtToken();

    if(token) {
      return {
        'Authorization': "Bearer" + token,
        'Content-Type': 'application/json'
      };
    } else {
      return {
        'Content-Type': 'application/json'
      };
    }
  }
}

