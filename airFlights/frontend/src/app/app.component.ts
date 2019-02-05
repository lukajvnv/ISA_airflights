import { Component, OnInit } from '@angular/core';
import { LoggedUserService } from './services/logged-user.service';
import { AuthTokenService } from './services/auth-token.service';
import { getToken } from '@angular/router/src/utils/preactivation';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'ISA Airflight project';

  isUserLogged: boolean;
  loggedUser: String;

  constructor(private loggedUserService: LoggedUserService, private authToken: AuthTokenService) {}

  ngOnInit() {

    if (this.authToken.getJwtToken()) {
      this.isUserLogged = true;
      this.loggedUser = localStorage.getItem('currentUser');
    } else {
      this.isUserLogged = false;
    }
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    this.authToken.removeJwtToken();
    location.reload();
  }
}

export interface LoggedUser {
  username: string;
}
